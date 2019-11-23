//https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
public class MaxDepthBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftResult = 1, rightResult = 1;

        if (root.left != null) {
            leftResult = 1 + maxDepth(root.left);
        }
        if (root.right != null) {
            rightResult = 1 + maxDepth(root.right);
        }

        return Math.max(leftResult, rightResult);
    }
}
