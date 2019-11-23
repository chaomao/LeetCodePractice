import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubsetsTest {

    private Subsets subsets = new Subsets();

    @Test
    void should_return_1_list() {
        List<List<Integer>> expectResults = generateLists(new int[][]{
                new int[]{}
        });
        List<List<Integer>> results = this.subsets.subsets(new int[]{});
        assertEquals(expectResults, results);
    }

    @Test
    void should_return_2_list() {
        List<List<Integer>> expectResults = generateLists(new int[][]{
                new int[]{},
                new int[]{1}
        });
        List<List<Integer>> results = this.subsets.subsets(new int[]{1});
        assertEquals(expectResults, results);
    }

    @Test
    void should_return_4_lists() {
        List<List<Integer>> expectResults = generateLists(new int[][]{
                new int[]{},
                new int[]{1},
                new int[]{1,2},
                new int[]{2},
        });
        List<List<Integer>> results = this.subsets.subsets(new int[]{1, 2});
        assertEquals(expectResults, results);
    }

    @Test
    void should_return_8_lists() {
        List<List<Integer>> expectResults = generateLists(new int[][]{
                new int[]{},
                new int[]{1},
                new int[]{1,2},
                new int[]{1,2,3},
                new int[]{1,3},
                new int[]{2},
                new int[]{2,3},
                new int[]{3},
        });
        List<List<Integer>> results = this.subsets.subsets(new int[]{1, 2, 3});
        assertEquals(expectResults, results);
    }

    @Test
    void should_return_16_lists() {
        List<List<Integer>> expectResults = generateLists(new int[][]{
                new int[]{},
                new int[]{1},
                new int[]{1,2},
                new int[]{1,2,3},
                new int[]{1,2,3,4},
                new int[]{1,2,4},
                new int[]{1,3},
                new int[]{1,3,4},
                new int[]{1,4},
                new int[]{2},
                new int[]{2,3},
                new int[]{2,3,4},
                new int[]{2,4},
                new int[]{3},
                new int[]{3,4},
                new int[]{4},
        });
        List<List<Integer>> results = this.subsets.subsets(new int[]{1, 2, 3, 4});
        assertEquals(expectResults, results);
    }

    @Test
    void should_equal_array_list() {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        arrayLists.add(new ArrayList<>(Arrays.asList(1, 2)));
        arrayLists.add(new ArrayList<>(Arrays.asList(3, 4)));

        ArrayList<ArrayList<Integer>> anotherArrayLists = new ArrayList<>();
        anotherArrayLists.add(new ArrayList<>(Arrays.asList(1, 2)));
        anotherArrayLists.add(new ArrayList<>(Arrays.asList(3, 4)));

        assertEquals(arrayLists, anotherArrayLists);
    }

    static List<List<Integer>> generateLists(int[][] nums) {
        List<List<Integer>> results = new ArrayList<>();
        for (int[] num : nums) {
            ArrayList<Integer> list = new ArrayList<>(nums.length);
            for (int j : num) {
                list.add(j);
            }
            results.add(list);
        }

        return results;
    }
}