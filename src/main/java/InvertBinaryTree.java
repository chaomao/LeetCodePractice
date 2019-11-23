public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        root.right = invertTree(root.right);
        root.left = invertTree(root.left);

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }
}
