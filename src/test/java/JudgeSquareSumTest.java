import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JudgeSquareSumTest {
    private JudgeSquareSum judge = new JudgeSquareSum();

    @Test
    void should_return_true_for_5 () {
        // 1 * 1 + 2 * 2
        assertTrue(judge.judgeSquareSum(5));
    }

    @Test
    void should_return_true_for_2 () {
        // 1 * 1 + 2 * 2
        assertTrue(judge.judgeSquareSum(2));
    }

    @Test
    void should_return_false_for_3 () {
        // no result found
        assertFalse(judge.judgeSquareSum(3));
    }

    @Test
    void should_return_true_for_4 () {
        // no result found
        assertTrue(judge.judgeSquareSum(4));
    }

    @Test
    void should_return_true_for_10 () {
        // 1 * 1 + 3 * 3
        assertTrue(judge.judgeSquareSum(10));
    }

}