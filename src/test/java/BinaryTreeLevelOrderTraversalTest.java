import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeLevelOrderTraversalTest {

    private BinaryTreeLevelOrderTraversal binary = new BinaryTreeLevelOrderTraversal();

    @Test
    void test() {
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(3));
        expected.add(Arrays.asList(9, 20));
        expected.add(Arrays.asList(15, 7));

        List<List<Integer>> result = binary.levelOrder(TreeNode.generateTree("3,9,20,null,null,15,7"));

        for (int i = 0; i < result.size(); i++) {
            assertEquals(expected.get(i), result.get(i));
        }
    }

}