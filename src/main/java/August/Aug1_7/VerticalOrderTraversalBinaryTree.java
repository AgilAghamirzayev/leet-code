package August.Aug1_7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
public class VerticalOrderTraversalBinaryTree {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        helper(root, map);
        return new ArrayList<>(map.values());
    }

    private void helper(TreeNode t, TreeMap<Integer, ArrayList<Integer>> map) {
        if (t == null) return;
        LinkedList<TreeNode> q1 = new LinkedList<>();
        LinkedList<Integer> q2 = new LinkedList<>();
        q1.offer(t);
        q2.offer(0);

        while (!q1.isEmpty()) {
            TreeNode node = q1.poll();
            int order = q2.poll();

            ArrayList<Integer> list = map.computeIfAbsent(order, k -> new ArrayList<>());
            list.add(node.val);

            if (node.left != null) {
                q1.offer(node.left);
                q2.offer(order - 1);
            }

            if (node.right != null) {
                q1.offer(node.right);
                q2.offer(order + 1);
            }
        }
    }
}
