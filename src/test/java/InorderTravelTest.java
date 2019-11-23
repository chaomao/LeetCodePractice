import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class InorderTravelTest {

    private InorderTravel inorder = new InorderTravel();

    @Test
    void root_is_null() {
        assertEquals(Collections.emptyList(), inorder.inorderTraversal(null));
    }

    @Test
    void root_is_not_null() {
        assertEquals(Collections.singletonList(1), inorder.inorderTraversal(TreeNode.generateTree("1")));
    }

    @Test
    void right_child() {
        assertEquals(Arrays.asList(1, 3, 2), inorder.inorderTraversal(TreeNode.generateTree("1,null,2,3")));
    }

}