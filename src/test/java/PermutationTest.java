import org.junit.jupiter.api.Test;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PermutationTest {

    private Permutation permutation = new Permutation();

    @Test
    void return_1_2_3_permutation() {
        List<List<Integer>> expectList = generateLists(new int[][]{
                new int[]{1,2,3},
                new int[]{1,3,2},
                new int[]{2,1,3},
                new int[]{2,3,1},
                new int[]{3,1,2},
                new int[]{3,2,1},
        });

        assertEquals(expectList, permutation.permute(new int[]{1, 2, 3}));
    }

    List<List<Integer>> generateLists(int[][] nums) {
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