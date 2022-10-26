package Daily.year2022.M10.D26;

import java.util.ArrayDeque;
import java.util.Deque;

public class q862 {
    public int shortestSubarray(int[] nums, int k) {
        //  子数组， 不能排序
        // 没有规律不能使用滑动窗口
        // 预处理：前缀和

        int n = nums.length;
        long[] preSum = new long[n + 1];
        // 1 2 3
        // 0 1 3 6
        for(int i = 0; i < n; i++){
            preSum[i + 1] = preSum[i] + nums[i];
        }
        // 从i开始长度为m的子数组和为 preSum[i + m] - preSum[i]

        int res = n + 1;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            long curSum = preSum[i];
            while(!queue.isEmpty() && curSum - preSum[queue.peekFirst()] >= k){
                // 找到了以i 为起点的最短子数组，所以可以poll
                res = Math.min(res, i - queue.pollFirst());
            }

            while(!queue.isEmpty() && preSum[queue.peekLast()] >= curSum){
                // 已经放入队列的只能作为减数存在，所以更大的可以去除
                queue.pollLast();
            }

            queue.offerLast(i);
        }
        return res < n + 1 ? res : -1;
    }
}
