import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvertBinaryTreeTest {

    private InvertBinaryTree invert = new InvertBinaryTree();

    @Test
    public void invert_full_tree() {
        TreeNode inputTree = TreeNode.generateTree("4,2,7,1,3,6,9");
        TreeNode expectTree = TreeNode.generateTree("4,7,2,9,6,3,1");

        TreeNode result = invert.invertTree(inputTree);

        assertEquals(expectTree, result);
    }

    @Test
    public void invert_left_null_tree() {
        TreeNode inputTree = TreeNode.generateTree("4,null,7");
        TreeNode expectTree = TreeNode.generateTree("4,7,null");

        TreeNode result = invert.invertTree(inputTree);

        assertEquals(expectTree, result);
    }

    @Test
    public void invert_right_null_tree() {
        TreeNode inputTree = TreeNode.generateTree("4,7,null");
        TreeNode expectTree = TreeNode.generateTree("4,null,7");

        TreeNode result = invert.invertTree(inputTree);

        assertEquals(expectTree, result);
    }

    @Test
    public void invert_complex_null_tree() {
        TreeNode inputTree = TreeNode.generateTree("4,2,7,null,3,6,null");
        TreeNode expectTree = TreeNode.generateTree("4,7,2,null,6,3,null");

        TreeNode result = invert.invertTree(inputTree);

        assertEquals(expectTree, result);
    }

}