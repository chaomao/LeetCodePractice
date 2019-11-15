import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteNodeTest {

    private DeleteNode deleteNode = new DeleteNode();

    @Test
    void delete_node_in_3rd() {
        ListNode head = ListNode.build(4, 5, 1, 9);

        deleteNode.deleteNode(head.next.next);

        assertEquals(ListNode.build(4,5,9), head);
    }

    @Test
    void delete_node_in_2nd() {
        ListNode head = ListNode.build(4, 5, 1, 9);

        deleteNode.deleteNode(head.next);

        assertEquals(ListNode.build(4,1,9), head);
    }

    @Test
    void delete_node_in_head() {
        ListNode head = ListNode.build(4, 5, 1, 9);

        deleteNode.deleteNode(head);

        assertEquals(ListNode.build(5,1,9), head);
    }
}