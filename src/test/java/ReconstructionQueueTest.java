import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReconstructionQueueTest {

    private ReconstructionQueue reconstructionQueue = new ReconstructionQueue();

    @Test
    void test() {
        int[][] expectResult = {
                new int[]{5, 0},
                new int[]{7, 0},
                new int[]{5, 2},
                new int[]{6, 1},
                new int[]{4, 4},
                new int[]{7, 1},
        };

        int[][] result = reconstructionQueue.reconstructQueue(new int[][]{
                new int[]{7, 0},
                new int[]{4, 4},
                new int[]{7, 1},
                new int[]{5, 0},
                new int[]{6, 1},
                new int[]{5, 2},

        });

        for (int i = 0; i < expectResult.length; i++) {
            assertArrayEquals(expectResult[i], result[i]);
        }
    }

}