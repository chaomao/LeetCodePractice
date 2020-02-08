import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExplainNumberTest {
    private ExplainNumber explain = new ExplainNumber();

    @Test
    void explain_1() {
        assertEquals(explain.explainNumber("1"), 1);
    }

    @Test
    void explain_12() {
        assertEquals(explain.explainNumber("12"), 2);
    }

    @Test
    void explain_27() {
        assertEquals(explain.explainNumber("27"), 1);
    }

    @Test
    void explain_1212() {
        assertEquals(explain.explainNumber("1212"), 5);
    }

    @Test
    void explain_226() {
        assertEquals(explain.explainNumber("226"), 3);
    }

    @Test
    void explain_00() {
        assertEquals(explain.explainNumber("00"), 0);
    }
}