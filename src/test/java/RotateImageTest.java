import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RotateImageTest {

    private RotateImage rotate = new RotateImage();

    @Test
    void test_1() {
        int[][] matrix = {
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9},

        };

        int[][] expectResult = {
                new int[]{7, 4, 1},
                new int[]{8, 5, 2},
                new int[]{9, 6, 3},

        };

        rotate.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            assertArrayEquals(expectResult[i], matrix[i]);
        }
    }


    @Test
    void test_2() {
        int[][] matrix = {
                new int[]{5, 1, 9, 11},
                new int[]{2, 4, 8, 10},
                new int[]{13, 3, 6, 7},
                new int[]{15, 14, 12, 16},

        };

        int[][] expectResult = {
                new int[]{15, 13, 2, 5},
                new int[]{14, 3, 4, 1},
                new int[]{12, 6, 8, 9},
                new int[]{16, 7, 10, 11},

        };

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
//            assertArrayEquals(expectResult[i], matrix[i]);
        }

        System.out.println();
        rotate.rotate(matrix);


        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
//            assertArrayEquals(expectResult[i], matrix[i]);
        }
    }

}