package question;

import Common.ListNode;

import java.sql.ClientInfoStatus;
import java.util.List;

public class q23 {
    public ListNode mergeKLists(ListNode[] lists) {
        // 分治
        // 合并升序列表, 减少合并次数
        int n = lists.length;

        if(n == 0){
            return null;
        }

        mergeList(0, n-1, lists);

        return lists[0];
    }

    void mergeList(int start, int end, ListNode[] lists){

        if(start >= end){
            return;
        }

        int mid = start + (end - start) / 2;
        mergeList(start, mid, lists);
        mergeList(mid + 1, end, lists);

        // 合并两个有序链表
        mergeTwoLists(start, mid, lists);
    }

    void mergeTwoLists(int i, int j, ListNode[] lists){
        // 为空
        if(lists[i] == null || lists[j] == null){
            lists[i] = lists[j] == null ? lists[i] : lists[j];
            return;
        }

        ListNode pre = new ListNode(0);
        ListNode head = pre;
        ListNode a = lists[i], b = lists[j];

        while (a != null && b != null){
            if(a.val < b.val){
                head.next = a;
                a = a.next;
            }else {
                head.next = b;
                b = b.next;
            }
            head = head.next;
        }

        head.next = (a == null ? b : a);

        lists[i] = pre.next;
    }
}
