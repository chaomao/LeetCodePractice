//https://leetcode-cn.com/problems/merge-two-binary-trees/
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class MergeBinaryTree {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        }

        t1.val += t2.val;

        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        this.val = x;
    }

    static TreeNode generateTree(String treeString) {
        String[] parts = treeString.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int index = 1;
        String item;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();

            if (index == parts.length) break;

            item = parts[index++];
            if (!item.equals("null")) {
                node.left = new TreeNode(Integer.parseInt(item.trim()));
                queue.add(node.left);
            }

            if (index == parts.length) break;

            item = parts[index++];
            if (!item.equals("null")) {
                node.right = new TreeNode(Integer.parseInt(item.trim()));
                queue.add(node.right);
            }
        }

        return root;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(val);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof TreeNode) {
            TreeNode anotherNode = (TreeNode) obj;
            if (this.val != anotherNode.val) return false;

            return Objects.equals(this.left, anotherNode.left) &&
                    Objects.equals(this.right, anotherNode.right);

        } else {
            return false;
        }
    }
}
