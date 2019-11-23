import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxDepthBinaryTreeTest {

    private MaxDepthBinaryTree max = new MaxDepthBinaryTree();

    @Test
    void depth_is_3() {
        TreeNode treeNode = TreeNode.generateTree("3,9,20,null,null,15,7");
        assertEquals(3, max.maxDepth(treeNode));
    }

}