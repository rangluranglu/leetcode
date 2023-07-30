package Year2023.Daily.M7.D29;

import Common.ListNode;

import javax.sound.midi.Track;

public class q141 {
    public boolean hasCycle(ListNode head) {
        // 141.环形链表

        ListNode fast = head;
        ListNode slow = head;

        while (fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                return true;
            }
        }

        return false;
    }
}
