import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinPathSumTest {

    private MinPathSum min = new MinPathSum();

    @Test
    void test_1() {
        int[][] grid = {
                new int[]{1, 3, 1},
                new int[]{1, 5, 1},
                new int[]{4, 2, 1}

        };
        assertEquals(7, min.minPathSum(grid));
    }

    @Test
    void test_2() {
        int[][] grid = {
                new int[]{1, 3},
                new int[]{1, 5},
                new int[]{4, 2}

        };
        assertEquals(8, min.minPathSum(grid));
    }

}