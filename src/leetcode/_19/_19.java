package leetcode._19;

import java.lang.StringBuilder;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// @solution-sync:begin
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode p1 = dummy, p2 = dummy;
        for (int i = 1; i < n+1; i++) {
            p2 = p2.next;
        }
        while (p2.next!=null){
            p1=p1.next;
            p2=p2.next;
        }
        p1.next=p1.next.next;
        return dummy.next;
    }
}
// @solution-sync:end

class Main {

    public static void main(String[] args) {
        ListNode head = parseListNode(new int[]{1, 2, 3, 4, 5});
        int n = 2;

        ListNode result = new Solution().removeNthFromEnd(head, n);
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
