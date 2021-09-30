package leetcode._114;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// @solution-sync:begin
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}
// @solution-sync:end

class Main {

    public static void main(String[] args) {
        TreeNode root = parseTreeNode(new Integer[]{1, 2, 5, 3, 4, null, 6});
        new Solution().flatten(root);
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

}

