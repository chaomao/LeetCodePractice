import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenerateParenthesisTest {

    private GenerateParenthesis generate = new GenerateParenthesis();

    @Test
    void test_n_is_0() {
        assertEquals(Collections.<String>emptyList(), generate.generateParenthesis(0));
    }

    @Test
    void test_n_is_1() {
        assertEquals(Collections.singletonList("()"),
                generate.generateParenthesis(1));
    }

    @Test
    void test_n_is_2() {
        assertEquals(Arrays.asList("(())", "()()"),
                generate.generateParenthesis(2));
    }

    @Test
    void test_n_is_3() {
        assertEquals(Arrays.asList(
                "((()))",
                "(()())",
                "(())()",
                "()(())",
                "()()()"),
                generate.generateParenthesis(3));
    }

}