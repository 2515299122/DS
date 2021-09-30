package leetcode._116;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

// @solution-sync:begin
class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        connectTwoNode(root.left, root.right);
        return root;
    }

    private void connectTwoNode(Node p1, Node p2) {
        if (p1 == null || p2 == null) return;
        p1.next = p2;
        connectTwoNode(p1.left, p1.right);
        connectTwoNode(p2.left, p2.right);
        connectTwoNode(p1.right, p2.left);
    }
}
// @solution-sync:end

class Main {

    public static void main(String[] args) {

    }

}

