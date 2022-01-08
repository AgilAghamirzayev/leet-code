package algorithms.medium;

class ListNode {
    int val;
    ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class LinkedListRandomNode {

    ListNode head;

    public LinkedListRandomNode(ListNode head) {
        this.head = head;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode();
        list.val = 1;
        list.next = new ListNode(2, new ListNode(3));

        LinkedListRandomNode solution = new LinkedListRandomNode(list);

        System.out.println(solution.getRandom());

    }

    public int getRandom() {
        ListNode curr = head;
        int i = 1;
        int res = 0;

        while (curr != null) {
            if (Math.random() < 1.0 / i) {
                res = curr.val;
            }
            i++;
            curr = curr.next;
        }

        return res;
    }
}
