import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {

    private ContainerWithMostWater container = new ContainerWithMostWater();

    @Test
    void test() {
        assertEquals(49, container.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

}