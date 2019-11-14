// https://leetcode-cn.com/problems/add-two-numbers/

import java.util.List;
import java.util.Objects;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;
        while (node1 != null || node2 != null || carry != 0) {
            int temp = tempSum(node1, node2, carry);
            carry = temp / 10;
            current.next = new ListNode(temp % 10);
            current = current.next;
            if (node1 != null) {
                node1 = node1.next;
            }
            if (node2 != null) {
                node2 = node2.next;
            }
        }
        return dummyHead.next;
    }

    private int tempSum(ListNode node1, ListNode node2, int carry) {
        return ((node1 != null) ? node1.val : 0) + ((node2 != null) ? node2.val : 0) + carry;
    }

    public static void main(String[] args) {
        ListNode node1 = ListNode.build(1, 2, 3);

        ListNode node = node1;
        ListNode head = null;
        ListNode current = null;
        boolean firstFlag = true;
        while (node != null) {
            if (firstFlag) {
                head = new ListNode(node.val);
                current = head;
                firstFlag = false;
            } else {
                current.next = new ListNode(node.val);
                current = current.next;
            }
            node = node.next;
        }

        printNodeList(head);
    }

    static void printNodeList(ListNode listNode) {
        ListNode head = listNode;
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}


class ListNode {
    int val;

    ListNode next;

    ListNode(int x) {
        this.val = x;
    }

    static ListNode build(int... list) {
        ListNode head = null;
        ListNode current = null;
        for (int i = 0; i < list.length; i++) {
            if (i == 0) {
                head = new ListNode(list[i]);
                current = head;
            } else {
                current.next = new ListNode(list[i]);
                current = current.next;
            }
        }
        return head;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }

        if (obj instanceof ListNode) {
            ListNode target = (ListNode) obj;
            ListNode head = this;

            while (head != null && target != null) {
                if (head.val != target.val) {
                    return false;
                }
                target = target.next;
                head = head.next;
            }
            return head == null && target == null;

        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.val);
    }
}

