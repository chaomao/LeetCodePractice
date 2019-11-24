import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DuplicateNumberTest {

    private DuplicateNumber duplicateNumber = new DuplicateNumber();

    @Test
    void should_2() {
        assertEquals(2, duplicateNumber.findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }

    @Test
    void should_3() {
        assertEquals(3, duplicateNumber.findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }

}