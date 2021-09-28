package base.tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    TNode root;

    BinaryTree() {
        this.root = new TNode();
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void createTreeByRecursion(char[] treeNodes) {
        createTreeByRecursion(root, treeNodes, 0);
    }

    private int createTreeByRecursion(TNode node, char[] treeNodes, int n) {
        if ('#' == treeNodes[n])
            return n + 1;
        node.data = treeNodes[n];
        node.lchild = new TNode();
        int left = createTreeByRecursion(node.lchild, treeNodes, n + 1);
        node.rchild = new TNode();
        return createTreeByRecursion(node.rchild, treeNodes, left);
    }

    public void preOrder(TNode root) {
        if (root != null) {
            System.out.print(root.data);
            preOrder(root.lchild);
            preOrder(root.rchild);
        }
    }

    public void inOrder(TNode root) {
        if (root != null) {
            inOrder(root.lchild);
            System.out.print(root.data);
            inOrder(root.rchild);
        }
    }

    public void postOrder(TNode root) {
        if (root != null) {
            postOrder(root.lchild);
            postOrder(root.rchild);
            System.out.print(root.data);
        }
    }

    public void preOrderByRecursion(TNode root) {
        if (isEmpty()) return;
        Stack<TNode> stack = new Stack<>();
        TNode node;
        stack.push(root);
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.print(node.data);
            if (node.rchild != null) {
                stack.push(node.rchild);
            }
            if (node.lchild != null) {
                stack.push(node.lchild);
            }
        }
    }

    public void inOrderByRecursion(TNode root) {
        Stack<TNode> stack = new Stack<>();
        TNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.lchild;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.print(node.data);
                node = node.rchild;
            }
        }
    }

    public void postOrderByRecursion(TNode root) {
        if (isEmpty()) return;
        Stack<TNode> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        TNode node;
        s1.push(root);
        while (!s1.isEmpty()) {
            node = s1.pop();
            s2.push(node.data);
            if (node.lchild != null) {
                s1.push(node.lchild);
            }
            if (node.rchild != null) {
                s1.push(node.rchild);
            }
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.pop());
        }
    }

    public void levelOrder() {
        if (isEmpty()) return;
        TNode node;
        Queue<TNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.print(node.data);
            if (node.lchild != null) {
                queue.offer(node.lchild);
            }
            if (node.rchild != null) {
                queue.offer(node.rchild);
            }
        }
    }

    public static void main(String[] args) {
        /*ABD G  E H  C F
         * D G B E H A C F
         *   GD   HEB   FCA
         * ABCDE F G H
         */
        /*                  A
        *              B         C
        *           D     E     #  F
        *          # G   # #      # H
        *           # #
        * */
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createTreeByRecursion("ABD#G##E#H##C#F##".toCharArray());
        binaryTree.preOrder(binaryTree.root);
        System.out.println();
        binaryTree.inOrder(binaryTree.root);
        System.out.println();
        binaryTree.postOrder(binaryTree.root);
        System.out.print("\n================================\n");
        binaryTree.preOrderByRecursion(binaryTree.root);
        System.out.println();
        binaryTree.inOrderByRecursion(binaryTree.root);
        System.out.println();
        binaryTree.postOrderByRecursion(binaryTree.root);
        System.out.print("\n================================\n");
        binaryTree.levelOrder();
    }

    class TNode {
        char data;
        TNode lchild;
        TNode rchild;
    }
}
