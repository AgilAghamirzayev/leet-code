package May.May_1_7;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class CousinsInBinaryTree {

    Node xNode = new Node();
    Node yNode = new Node();
    int x, y;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        preOrder(root,0,1);
        return xNode.parent != yNode.parent && xNode.depth == yNode.depth;
    }


    private void preOrder(TreeNode root, int parent, int depth) {
        if (root == null) return;
        if (root.val == x){
            xNode.parent = parent;
            xNode.depth = depth;
        }

        if (root.val == y){
            yNode.parent = parent;
            yNode.depth = depth;
        }

        preOrder(root.left,root.val,depth+1);
        preOrder(root.right,root.val,depth+1);
    }

    class Node {
        int parent;
        int depth;
    }

}
