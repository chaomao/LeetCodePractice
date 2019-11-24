import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortedListTest {

    private MergeSortedList merge = new MergeSortedList();

    @Test
    void test() {
        ListNode expectedList = ListNode.build(1, 1, 2, 3, 4, 4);
        assertEquals(expectedList, merge.mergeTwoLists(ListNode.build(1,2,4), ListNode.build(1,3,4)));
    }

}