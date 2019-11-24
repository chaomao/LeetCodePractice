import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MajorityElementTest {
    private MajorityElement majorityElement = new MajorityElement();

    @Test
    void should_3() {
        assertEquals(3, majorityElement.majorityElement(new int[]{3, 2, 3}));
    }

    @Test
    void should_2() {
        assertEquals(2, majorityElement.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    @Test
    void should_1() {
        assertEquals(1, majorityElement.majorityElement(new int[]{1}));
    }

}