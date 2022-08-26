package question;

import Common.ListNode;

public class q143 {
    public void reorderList(ListNode head) {
        // 找到中点
        ListNode middle = findMiddle(head);

        // 分割前后链表
        ListNode secondHead = middle.next;
        middle.next = null;

        // 翻转第二个链表
        ListNode newHead = reverseList(secondHead);

        // 合并两个链表
        mergeTwoList(head, newHead);
    }

    private void mergeTwoList(ListNode head, ListNode newHead) {
        ListNode p1 = head;
        ListNode p2 = newHead;

        while(p2 != null){
            ListNode next = p2.next;

            p2.next = p1.next;
            p1.next = p2;

            p1 = p2.next;
            p2 = next;
        }
    }

    private ListNode reverseList(ListNode secondHead) {

        // 迭代
        if(secondHead == null){
            return secondHead;
        }

        ListNode pre = null, cur = secondHead;

        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre= cur;
            cur = next;
        }
        return pre;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
