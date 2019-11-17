import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HammingDistanceTest {

    private HammingDistance hamming = new HammingDistance();

    @Test
    void distance_2() {
        assertEquals(2, hamming.hammingDistance(1,4));
    }

    @Test
    void distance_0() {
        assertEquals(1, hamming.hammingDistance(5,4));
    }

    @Test
    void distance_3_and_1() {
        assertEquals(1, hamming.hammingDistance(3,1));
    }


    @Test
    void distance_0_again() {
        assertEquals(1, hamming.hammingDistance(5,7));
    }

    @Test
    void distance_1_again() {
        assertEquals(2, hamming.hammingDistance(7, 11));
    }

    @Test
    void test(){
        System.out.println(1 & 4);
        System.out.println(1 | 4);
    }

}