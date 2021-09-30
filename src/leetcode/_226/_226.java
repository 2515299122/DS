package leetcode._226;

import java.util.List;
import java.util.LinkedList;
import java.lang.StringBuilder;

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

// @solution-sync:begin
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
// @solution-sync:end

class Main {

    public static void main(String[] args) {
        TreeNode root = parseTreeNode(new Integer[]{4, 2, 7, 1, 3, 6, 9});

        TreeNode result = new Solution().invertTree(root);
        System.out.println(toString(result));
    }

    private static TreeNode parseTreeNode(Integer[] values) {
        TreeNode root = null;
        java.util.LinkedList<TreeNode> nodes = new java.util.LinkedList<TreeNode>();
        int i = 0;
        while (i < values.length) {
            if (i == 0) {
                root = new TreeNode(values[i]);
                i += 1;
                nodes.addLast(root);
                continue;
            }

            TreeNode parent = nodes.pop();
            if (values[i] != null) {
                TreeNode left = new TreeNode(values[i]);
                parent.left = left;
                nodes.addLast(left);
            }

            if (i + 1 < values.length && values[i + 1] != null) {
                TreeNode right = new TreeNode(values[i + 1]);
                parent.right = right;
                nodes.addLast(right);
            }

            i += 2;
        }
        return root;
    }

    private static int getLevelCount(TreeNode node) {
        if (node == null) return 0;
        int leftMaxLevel = 1 + getLevelCount(node.left);
        int rightMaxLevel = 1 + getLevelCount(node.right);
        return Math.max(leftMaxLevel, rightMaxLevel);
    }

    private static void toString(StringBuilder buf, TreeNode node, int level) {
        if (level == 0) {
            if (node != null)
                buf.append(node.val);
            else
                buf.append("null");
            buf.append(",");
        }
        if (node != null) {
            toString(buf, node.left, level - 1);
            toString(buf, node.right, level - 1);
        }
    }

    private static String toString(TreeNode root) {
        StringBuilder buf = new StringBuilder();
        int levelCount = getLevelCount(root);
        for (int i = 0; i < levelCount; ++i)
            toString(buf, root, i);
        String result = buf.toString();
        result = result.substring(0, result.length() - 1);
        return "[" + result + "]";
    }

}
