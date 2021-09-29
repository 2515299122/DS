package leetcode._jz22;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

// @solution-sync:begin
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null) return null;
        ListNode p1 = head, p2 = head;
        for (int i = 1; i < k; i++) {
            p2 = p2.next;
        }
        while (p2.next!=null){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }
}
// @solution-sync:end

class Main {

    public static void main(String[] args) {
        ListNode head = parseListNode(new int[]{1, 2, 3, 4, 5});
        int k = 3;

        ListNode result = new Solution().getKthFromEnd(head, k);
        System.out.println(toString(result));
    }

    private static ListNode parseListNode(int[] values) {
        ListNode head = null;
        ListNode tail = null;
        for (int value : values) {
            ListNode node = new ListNode(value);
            if (head == null)
                head = node;
            else
                tail.next = node;
            tail = node;
        }
        return head;
    }

    private static String toString(ListNode h) {
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        ListNode c = h;
        while (c != null) {
            buf.append(c.val);
            if (c.next != null)
                buf.append(",");
            c = c.next;
        }
        buf.append("]");
        return buf.toString();
    }

}

