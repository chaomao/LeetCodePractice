import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxIncreaseToKeepCitySkylineTest {

    private MaxIncreaseToKeepCitySkyline city = new MaxIncreaseToKeepCitySkyline();

    @Test
    void test_case_1() {
        int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        assertEquals(35, city.maxIncreaseKeepingSkyline(grid));
    }

    @Test
    void test_case_2() {
        int[][] grid = {{0,0,0,0},{0,0,0,0},{0,1,0,0},{0,0,0,0}};
        assertEquals(0, city.maxIncreaseKeepingSkyline(grid));
    }

}