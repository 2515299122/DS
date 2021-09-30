package leetcode._160;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

// @solution-sync:begin
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1=headA,p2=headB;
        while (p1!=p2){
            if(p1==null) p1=headB;
            else p1=p1.next;
            if(p2==null) p2=headA;
            else p2=p2.next;
        }
        return p1;
    }
}
// @solution-sync:end

class Main {

    public static void main(String[] args) {
        ListNode headA = parseListNode(new int[]{4, 1, 8, 4, 5});
        ListNode headB = parseListNode(new int[]{5, 6, 1, 8, 4, 5});

        ListNode result = new Solution().getIntersectionNode(headA, headB);
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

