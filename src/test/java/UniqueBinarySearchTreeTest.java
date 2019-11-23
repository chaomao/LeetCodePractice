import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqueBinarySearchTreeTest {

    private UniqueBinarySearchTree unique = new UniqueBinarySearchTree();

    @Test
    void test_1() {
        assertEquals(5, unique.numTrees(3));
    }

}