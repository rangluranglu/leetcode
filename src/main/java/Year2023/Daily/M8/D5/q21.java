package Year2023.Daily.M8.D5;

import Common.ListNode;

import java.util.List;

public class q21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while(list1 != null && list2!= null){
            if(list1.val < list2.val){
                head.next = list1;
                list1 = list1.next;
            }else{
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }

        head.next = list1 == null ? list2 : list1;

        return dummy.next;
    }
}
