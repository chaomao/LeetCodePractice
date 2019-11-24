import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode-cn.com/problems/binary-tree-level-order-traversal
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        int level = 0;

        levelOrderRecur(level, root, result);
        return result;
    }

    public void levelOrderRecur(int level, TreeNode node, List<List<Integer>> result) {
        if(level == result.size()) result.add(new ArrayList<>());

        result.get(level).add(node.val);

        if (node.left != null) levelOrderRecur(level + 1, node.left, result);
        if (node.right != null) levelOrderRecur(level + 1, node.right, result);
    }

    public List<List<Integer>> levelLoop(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        int level = 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            result.add(new ArrayList<>());

            int length = nodes.size();
            for (int i = 0; i < length; i++) {
                TreeNode currentNode = nodes.poll();

                result.get(level).add(currentNode.val);

                if (currentNode.left != null) nodes.add(currentNode.left);
                if (currentNode.right != null) nodes.add(currentNode.right);
            }
            level++;
        }

        return result;
    }
}
