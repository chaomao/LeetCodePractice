import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class AddTwoNumbersTest {

    private final AddTwoNumbers twoNumbers = new AddTwoNumbers();

    @Test
    void test_equal() {
        assertEquals(ListNode.build(1, 2, 3), ListNode.build(1, 2, 3));
    }

    @Test
    void test_not_equal() {
        assertNotEquals(ListNode.build(1, 2, 3), ListNode.build(1, 1, 3));
    }

    @Test
    void test_not_equal_in_different_length() {
        assertNotEquals(ListNode.build(1, 2, 3), ListNode.build(1, 2, 3, 4));
    }

    @Test
    void same_length() {
        ListNode list1 = ListNode.build(2, 4, 3);
        ListNode list2 = ListNode.build(5, 6, 4);

        ListNode result = twoNumbers.addTwoNumbers(list1, list2);

        assertEquals(result, ListNode.build(7, 0, 8));
    }

    @Test
    void test_5_add_5() {
        ListNode list1 = ListNode.build(5);
        ListNode list2 = ListNode.build(5);

        ListNode result = twoNumbers.addTwoNumbers(list1, list2);

        assertEquals(result, ListNode.build(0, 1));
    }

    @Test
    void different_length() {
        ListNode list1 = ListNode.build(2, 4, 3);
        ListNode list2 = ListNode.build(8, 4);

        ListNode result = twoNumbers.addTwoNumbers(list1, list2);

        assertEquals(result, ListNode.build(0, 9, 3));
    }

    @Test
    void same_length_with_carry() {
        ListNode list1 = ListNode.build(2, 4, 9);
        ListNode list2 = ListNode.build(8, 6);

        ListNode result = twoNumbers.addTwoNumbers(list1, list2);

        assertEquals(result, ListNode.build(0, 1, 0, 1));
    }
}