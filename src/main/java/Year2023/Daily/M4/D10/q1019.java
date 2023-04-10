package Year2023.Daily.M4.D10;

import Common.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class q1019 {
    public int[] nextLargerNodes(ListNode head) {
        // 单调栈
        List<Integer> ans = new ArrayList<>();

        // 栈存储元素 位置和值
        Deque<int[]> stack = new ArrayDeque<>();

        ListNode cur = head;
        int idx = -1;
        while (cur != null){
            idx ++;

            ans.add(0);
            while (!stack.isEmpty() && stack.peek()[0] < cur.val){
                ans.set(stack.pop()[1], cur.val);
            }

            stack.push(new int[]{cur.val, idx});
            cur = cur.next;
        }

        int size = ans.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = ans.get(i);
        }

        return arr;
    }

}
