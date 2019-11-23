import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleNumberTest {

    private SingleNumber single = new SingleNumber();

    @Test
    void test(){
        assertEquals(1, single.singleNumber(new int[]{2, 2, 1}));
    }


}