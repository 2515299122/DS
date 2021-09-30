package leetcode._141;

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
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head, p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) return true;
        }
        return false;
    }
}
// @solution-sync:end

class Main {

    public static void main(String[] args) {
        ListNode head = parseListNode(new int[]{3, 2, 0, -4});

        boolean result = new Solution().hasCycle(head);
        System.out.println(result);
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

}

