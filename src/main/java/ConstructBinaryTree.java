//https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/
import java.util.HashMap;

public class ConstructBinaryTree {

    private HashMap<Integer, Integer> inOrderIndex = new HashMap<>();
    private int[] preOrder;

    private int preIndex = 0;

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        this.preOrder = preOrder;
        for (int i = 0; i < inOrder.length; i++) inOrderIndex.put(inOrder[i], i);
        return construct(0, inOrder.length);

    }

    private TreeNode construct(int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) return null;

        int rootValue = this.preOrder[preIndex];
        TreeNode root = new TreeNode(rootValue);

        Integer rootIndex = inOrderIndex.get(rootValue);

        preIndex++;
        root.left = construct(leftIndex, rootIndex);

        root.right = construct(rootIndex + 1, rightIndex);

        return root;
    }
}
