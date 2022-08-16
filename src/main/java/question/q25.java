package question;

public class q25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;

        while(head != null){
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if(tail == null){
                    return dummy.next;
                }
            }

            ListNode nextHead = tail.next;
            ListNode[] reversed = myReverse(head, tail);

            head = reversed[0];
            tail = reversed[1];

            // 重新链接
            pre.next = head;
            tail.next = nextHead;
            pre = tail;
            head = tail.next;
        }


        return dummy.next;
    }


    public ListNode[] myReverse(ListNode head, ListNode tail){
        ListNode prev = tail.next;
        ListNode p = head;

        while(prev != tail){
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }

        return new ListNode[]{tail, head};
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}