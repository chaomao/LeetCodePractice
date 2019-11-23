import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstructBinaryTreeTest {

    private ConstructBinaryTree constructor = new ConstructBinaryTree();

    @Test
    void test() {
        assertEquals(
                TreeNode.generateTree("3,9,20,null,null,15,7"),
                constructor.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }
}