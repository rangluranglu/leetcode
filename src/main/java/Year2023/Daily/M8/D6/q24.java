package Year2023.Daily.M8.D6;

import Common.ListNode;

public class q24 {
    public ListNode swapPairs(ListNode head) {
        // 节点交换
        ListNode dummy = new ListNode(-1,head);

        ListNode tmp = dummy;

        while(tmp.next != null && tmp.next.next != null){
            ListNode node1 = tmp.next;
            ListNode node2 = tmp.next.next;

            tmp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            tmp = node1;
        }

        return dummy.next;
    }
}
