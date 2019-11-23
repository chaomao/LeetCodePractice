//https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
public class BinaryToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;

        if (root.left == null && root.right == null) return;

        if (root.right == null) {
            flatten(root.left);
            root.right = root.left;
            root.left = null;
            return;
        }

        if (root.left == null) {
            flatten(root.right);
            return;
        }

        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        while(left.right != null) left = left.right;
        left.right = root.right;
        root.right = root.left;
        root.left = null;
    }
}
