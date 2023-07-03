package Year2023.Daily.M7.D3;

import Common.ListNode;

public class q445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 翻转链表
        ListNode h1 = reverse(l1);
        ListNode h2 = reverse(l2);

        // 两数相加
        ListNode newHead = addTwo(h1, h2);

        return reverse(newHead);
    }

    private ListNode reverse(ListNode node){
        if(node == null || node.next == null){
            return node;
        }

        ListNode next = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return next;
    }

    private ListNode addTwo(ListNode h1, ListNode h2){
        ListNode head = new ListNode();
        ListNode dummy = head;
        int add = 0;
        while (h1 != null || h2 != null || add != 0){
            int sum = (h1 == null ? 0 : h1.val) + (h2 == null ? 0 : h2.val) + add;

            dummy.next = new ListNode(sum % 10);
            add = sum / 10;

            dummy = dummy.next;
            h1 = h1 == null ? h1 : h1.next;
            h2 = h2 == null ? h2 : h2.next;
        }

        return head.next;
    }
}
