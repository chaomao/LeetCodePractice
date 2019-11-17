import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CountBitsTest {

    private CountBits count = new CountBits();

    @Test
    void test_2() {
        assertArrayEquals(new int[]{0, 1, 1}, count.countBits(2));
    }

    @Test
    void test_5() {
        assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, count.countBits(5));
        System.out.println(5 & 4);
        System.out.println(6 & 5);
        System.out.println(7 & 6);
    }


}