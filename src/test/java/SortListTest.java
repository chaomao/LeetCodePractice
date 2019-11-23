import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortListTest {

    private SortList sort = new SortList();

    @Test
    void test() {
        assertEquals(
                ListNode.build(1, 2, 3, 4),
                sort.sortList(ListNode.build(4, 2, 1, 3)));
    }

}