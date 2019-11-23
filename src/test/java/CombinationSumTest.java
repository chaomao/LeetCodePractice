import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinationSumTest {

    private CombinationSum sum = new CombinationSum();

    @Test
    void target_is_7() {
        List<List<Integer>> expectedResult = SubsetsTest.generateLists(new int[][]{
                new int[]{2, 2, 3},
                new int[]{7}
        });
        assertEquals(expectedResult, sum.combinationSum(new int[]{2, 3, 6, 7}, 7));

    }

    @Test
    void target_is_8() {
        List<List<Integer>> expectedResult = SubsetsTest.generateLists(new int[][]{
                new int[]{2, 2, 2, 2},
                new int[]{2, 3, 3},
                new int[]{3, 5}
        });
        assertEquals(expectedResult, sum.combinationSum(new int[]{2, 3, 5}, 8));

    }
}