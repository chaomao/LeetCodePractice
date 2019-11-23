import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeBinaryTreeTest {

    private MergeBinaryTree merge = new MergeBinaryTree();

    @Test
    void test() {
        TreeNode tree1 = TreeNode.generateTree("1,3,2,5");

        TreeNode tree2 = TreeNode.generateTree("2,1,3,null,4,null,7");

        TreeNode resultTree = merge.mergeTrees(tree1, tree2);

        TreeNode expectTree = TreeNode.generateTree("3,4,5,5,4,null,7");

        assertNotEquals(tree1, tree2);
    }

    @Test
    void only_root_node() {
        TreeNode tree1 = TreeNode.generateTree("1");
        TreeNode tree2 = TreeNode.generateTree("3");

        TreeNode expectTree = TreeNode.generateTree("4");

        assertEquals(expectTree, merge.mergeTrees(tree1, tree2));
    }

    @Test
    void full_node() {
        TreeNode tree1 = TreeNode.generateTree("1,2,3");
        TreeNode tree2 = TreeNode.generateTree("3,4,5");

        TreeNode expectTree = TreeNode.generateTree("4,6,8");

        assertEquals(expectTree, merge.mergeTrees(tree1, tree2));
    }

    @Test
    void only_left_node() {
        TreeNode tree1 = TreeNode.generateTree("1,2");
        TreeNode tree2 = TreeNode.generateTree("3,4");

        TreeNode expectTree = TreeNode.generateTree("4,6");

        assertEquals(expectTree, merge.mergeTrees(tree1, tree2));
    }

    @Test
    void only_right_node() {
        TreeNode tree1 = TreeNode.generateTree("1,null,2");
        TreeNode tree2 = TreeNode.generateTree("3,null,4");

        TreeNode expectTree = TreeNode.generateTree("4,null,6");

        assertEquals(expectTree, merge.mergeTrees(tree1, tree2));
    }

    @Test
    void left_right_may_null_node() {
        TreeNode tree1 = TreeNode.generateTree("1,null,2");
        TreeNode tree2 = TreeNode.generateTree("3,4,null");

        TreeNode expectTree = TreeNode.generateTree("4,4,2");

        assertEquals(expectTree, merge.mergeTrees(tree1, tree2));
    }

    @Test
    void should_equal_root_tree() {
        TreeNode tree1 = TreeNode.generateTree("1,3,2,5");
        TreeNode tree2 = TreeNode.generateTree("1,3,2,5");

        assertEquals(tree1, tree2);
    }

    @Test
    void should_equal_left_node_null_tree() {
        TreeNode tree1 = TreeNode.generateTree("1,null,2");
        TreeNode tree2 = TreeNode.generateTree("1,null,2");

        assertEquals(tree1, tree2);
    }

    @Test
    void should_equal_right_node_null_tree() {
        TreeNode tree1 = TreeNode.generateTree("1,2,null");
        TreeNode tree2 = TreeNode.generateTree("1,2,null");

        assertEquals(tree1, tree2);
    }

    @Test
    void should_not_equal_right_node_null_tree() {
        TreeNode tree1 = TreeNode.generateTree("1,null,2");
        TreeNode tree2 = TreeNode.generateTree("1,2,null");

        assertNotEquals(tree1, tree2);
    }

    @Test
    void should_not_equal_root_node_tree() {
        TreeNode tree1 = TreeNode.generateTree("1");
        TreeNode tree2 = TreeNode.generateTree("2");

        assertNotEquals(tree1, tree2);
    }

}