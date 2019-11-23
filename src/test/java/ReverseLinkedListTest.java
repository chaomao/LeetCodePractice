import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListTest {

    private ReverseLinkedList reverse = new ReverseLinkedList();

    @Test
    void reverseLinkedList() {
        ListNode head = ListNode.build(1, 2, 3, 4, 5);
        assertEquals(ListNode.build(5, 4, 3, 2, 1), reverse.reverseList(head));
    }

    @Test
    void reverseLinkedList_1() {
        ListNode head = ListNode.build(1, 2);
        assertEquals(ListNode.build(2, 1), reverse.reverseList(head));
    }

}