
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JinSiZhiTest {

    private JinSiZhi jinsizhi = new JinSiZhi();

    @Test
    void test() {
        assertEquals(6, jinsizhi.calculate(5.5));
    }

}