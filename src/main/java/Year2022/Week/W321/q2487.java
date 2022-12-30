package Year2022.Week.W321;

import Common.ListNode;

public class q2487 {
    public ListNode removeNodes(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        dfs(dummy, head);
        return dummy.next;
    }

    private int dfs(ListNode pre, ListNode head) {

        if(head.next == null){
            return head.val;
        }
        int nex = dfs(head, head.next);
        if(head.val < nex){
            // 断开
            pre.next = head.next;
            head.next = null;
        }
        return Math.max(head.val, nex);
    }
}
