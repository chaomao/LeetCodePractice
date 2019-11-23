import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryToLinkedListTest {

    private BinaryToLinkedList binary = new BinaryToLinkedList();

    @Test
    void test() {
        TreeNode node = TreeNode.generateTree("1,2,5,3,4,null,6");
        binary.flatten(node);
        assertEquals(
                TreeNode.generateTree("1,null,2,null,3,null,4,null,5,null,6"),
                node);
    }

    @Test
    void test_root() {
        TreeNode node = TreeNode.generateTree("1");
        binary.flatten(node);
        assertEquals(
                TreeNode.generateTree("1"),
                node);
    }

    @Test
    void test_children() {
        TreeNode node = TreeNode.generateTree("1,2,3");
        binary.flatten(node);
        assertEquals(TreeNode.generateTree("1,null,2,null,3"), node);
    }

}