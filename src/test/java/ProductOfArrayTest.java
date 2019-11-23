import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductOfArrayTest {

    private ProductOfArray product = new ProductOfArray();

    @Test
    void test() {
        assertArrayEquals(new int[]{24,12,8,6}, product.productExceptSelf(new int[]{1,2,3,4}));
    }

}