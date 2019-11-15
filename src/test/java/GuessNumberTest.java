import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuessNumberTest {

    private GuessNumber guessNumber = new GuessNumber();

    @Test
    void should_return_3() {
        int[] guess = {1, 2, 3};
        int[] answer = {1, 2, 3};
        assertEquals(guessNumber.game(guess, answer), 3);
    }

    @Test
    void should_return_1() {
        int[] guess = {2, 2, 3};
        int[] answer = {3, 2, 1};
        assertEquals(guessNumber.game(guess, answer), 1);
    }

    @Test
    void should_return_0() {
        int[] guess = {1, 2, 3};
        int[] answer = {3, 1, 2};
        assertEquals(guessNumber.game(guess, answer), 0);
    }
}