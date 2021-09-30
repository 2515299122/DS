package leetcode._654;

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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return getRoot(nums, 0, nums.length - 1);
    }

    private TreeNode getRoot(int[] nums, int left, int right) {
        if (left > right) return null;
        int maxIndex = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = getRoot(nums, left, maxIndex - 1);
        root.right = getRoot(nums, maxIndex + 1, right);
        return root;
    }
}
// @solution-sync:end

class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};

        TreeNode result = new Solution().constructMaximumBinaryTree(nums);
        System.out.println(toString(result));
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

