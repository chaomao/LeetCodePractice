//https://leetcode-cn.com/problems/binary-tree-inorder-traversal/

import java.util.*;

public class InorderTravel {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        inorderLoop(root, result);
        return result;
    }

    private void inorderRecurrence(TreeNode root, ArrayList<Integer> result) {
        if (root == null) return;

        if (root.left != null) inorderRecurrence(root.left, result);
        result.add(root.val);
        if (root.right != null) inorderRecurrence(root.right, result);
    }

    private void inorderLoop(TreeNode node, ArrayList<Integer> result) {
        if (node == null) return;

        Stack<TreeNode> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        while(!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            result.add(currentNode.val);

            TreeNode right = currentNode.right;
            while(right != null) {
                stack.push(right);
                right = right.left;
            }
        }
    }
}
