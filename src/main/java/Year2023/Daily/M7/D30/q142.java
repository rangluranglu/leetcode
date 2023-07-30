package Year2023.Daily.M7.D30;

import Common.ListNode;

public class q142 {
    public ListNode detectCycle(ListNode head) {
        // 142.环形列表II

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                slow = head;

                while (slow != fast){
                    fast = fast.next;
                    slow = slow.next;
                }

                return slow;
            }
        }

        return null;
    }
}
