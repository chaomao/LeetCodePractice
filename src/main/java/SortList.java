public class SortList {

    public ListNode sortList(ListNode head) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;
        // 先统计长度f
        ListNode p = dummyHead.next;
        int length = 0;
        while (p != null) {
            ++length;
            p = p.next;
        }
        // 循环开始切割和合并
        for (int size = 1; size < length; size <<= 1) {
            ListNode current = dummyHead.next;
            ListNode tail = dummyHead;
            while (current != null) {
                ListNode left = current;
                ListNode right = cut(current, size); // 链表切掉size 剩下的返还给right
                current = cut(right, size); // 链表切掉size 剩下的返还给cur
                tail.next = merge(left, right);
                while (tail.next != null) {
                    tail = tail.next; // 保持最尾端
                }
            }
        }
        return dummyHead.next;
    }

    public ListNode cut(ListNode head, int n) {
        if (n <= 0) return head;
        ListNode p = head;
        // 往前走n-1步
        while (--n > 0 && p != null) {
            p = p.next;
        }
        if (p == null) return null;
        ListNode next = p.next;
        p.next = null;
        return next;
    }


    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE), current = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if (list1 == null) {
            current.next = list2;
        } else {
            current.next = list1;
        }
        return dummyHead.next;
    }
}
