package Year2023.Daily.M1.D30;

import Common.ListNode;

public class q1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode tail2 = list2;
        while (tail2.next != null){
            tail2 = tail2.next;
        }

        ListNode dummy = new ListNode(0, list1);
        ListNode head = dummy;

        ListNode nodeA = new ListNode(), nodeB = new ListNode();
        int depth = -1;
        while (dummy != null){
            dummy = dummy.next;
            depth ++;
            if(depth == a - 1){
                nodeA = dummy;
            }else if(depth == b + 1){
                nodeB = dummy;
                break;
            }
        }

        nodeA.next = list2;
        tail2.next = nodeB;

        return head.next;
    }
}
