package Year2023.Daily.M7.D2;

import Common.ListNode;

public class q2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode head = new ListNode();
        ListNode dummy = head;

        while (l1 != null || l2 != null || add != 0){
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + add;
            head.next = new ListNode(sum % 10);
            add = sum / 10;
            head = head.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }

        return dummy.next;
    }
}
