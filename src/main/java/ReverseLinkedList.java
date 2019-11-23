//https://leetcode-cn.com/problems/reverse-linked-list/

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode currentNode = head.next;
        head.next = null;
        ListNode tmp;
        while (currentNode != null) {
            tmp = currentNode.next;
            currentNode.next = newHead.next;
            newHead.next = currentNode;
            currentNode = tmp;

        }
        return newHead.next;
    }
}
