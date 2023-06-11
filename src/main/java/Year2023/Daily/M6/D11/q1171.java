package Year2023.Daily.M6.D11;

import Common.ListNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        // 有负数 才可能和为0
        // 前缀和 --> 如何存储, 1000个节点 可以存储map
        // 两次遍历
        int preSum = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur != null){
            preSum += cur.val;
            map.put(preSum, cur);
            cur = cur.next;
        }

        preSum = 0;
        cur = dummy;

        while (cur != null){
            preSum += cur.val;
            cur.next = map.get(preSum).next;
            cur = cur.next;
        }

        return dummy.next;

    }
}
