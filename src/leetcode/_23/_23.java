package leetcode._23;

import java.lang.StringBuilder;
import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// @solution-sync:begin
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0) return null;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(
                lists.length, Comparator.comparingInt(a -> a.val));
        ListNode dummy = new ListNode(), p = dummy;
        for (int i = 0; i < lists.length; i++) {
            if(lists[i]!=null){
                priorityQueue.offer(lists[i]);
            }
        }
        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            p.next = node;
            p = p.next;
            if (node.next != null) {
                priorityQueue.add(node.next);
            }
        }
        return dummy.next;
    }
}
// @solution-sync:end

class Main {

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[]{
                parseListNode(new int[]{1, 4, 5}),
                parseListNode(new int[]{1, 3, 4}),
                parseListNode(new int[]{2, 6})
        };

        ListNode result = new Solution().mergeKLists(lists);
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
