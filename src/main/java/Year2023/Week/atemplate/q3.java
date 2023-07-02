package Year2023.Week.atemplate;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class q3 {
    public long continuousSubarrays(int[] nums) {
        // 子数组相差不大于2，也就是子数组最多有两个数字
        // 滑动窗口

        int left = 0, n = nums.length, right = 0;
        long ans = 0;
        int lastRight = 0;

        // 双单调队列
        // 单调队列
        // 递减
        Deque<Integer> queue1 = new ArrayDeque<>();
        // 递增
        Deque<Integer> queue2 = new ArrayDeque<>();
        while (right < n){
            // stack1 递增栈 -- 从栈顶往栈底看，是单调递增的关系 -- 最小
            while (!queue1.isEmpty() && nums[queue1.peekFirst()] < nums[right]){
                queue1.pollFirst();
            }
            queue1.offerFirst(right);

            // stack2 递增 -- 最大
            while (!queue2.isEmpty() && nums[queue2.peekFirst()] > nums[right]){
                queue2.pollFirst();
            }
            queue2.offerFirst(right);

            while (nums[queue1.peekLast()] - nums[queue2.peekLast()] > 2){
                //如何更新最大值，最小值
                //System.out.println("left" + left + "right" + right);
                left ++;
                while (!queue1.isEmpty() && queue1.peekLast() < left){
                    queue1.pollLast();
                }
                while (!queue2.isEmpty() && queue2.peekLast() < left){
                    queue2.pollLast();
                }
            }

            right ++;
            ans += (right - left);

        }

        return ans;
    }
}
