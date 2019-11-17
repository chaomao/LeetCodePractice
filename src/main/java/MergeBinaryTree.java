//https://leetcode-cn.com/problems/merge-two-binary-trees/
import java.util.Objects;

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
