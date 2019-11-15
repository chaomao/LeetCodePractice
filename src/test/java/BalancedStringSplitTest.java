import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalancedStringSplitTest {

    private BalancedStringSplit balancedStringSplit = new BalancedStringSplit();

    @Test
    void should_return_4() {
        assertEquals(4, balancedStringSplit.balancedStringSplit("RLRRLLRLRL"));
    }

    @Test
    void should_return_3() {
        assertEquals(3, balancedStringSplit.balancedStringSplit("RLLLLRRRLR"));
    }

    @Test
    void should_return_1() {
        assertEquals(1, balancedStringSplit.balancedStringSplit("LLLLRRRR"));
    }

    @Test
    void should_return_3_again() {
        assertEquals(3, balancedStringSplit.balancedStringSplit("LRRLRRLL"));
    }

    @Test
    void should_return_1_again() {
        assertEquals(1, balancedStringSplit.balancedStringSplit("RRRLLRLL"));
    }
}