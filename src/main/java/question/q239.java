package question;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayDeque;
import java.util.Deque;

public class q239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 队列 存单调递减的数据

        int n = nums.length;
        int[] ans = new int[n - k + 1];

        Deque<Integer> queue = new ArrayDeque<>();
        // 初始化
        for (int i = 0; i < k; i++) {
            while(!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]){
                queue.pollLast();
            }
            queue.offerLast(i);
        }

        ans[0] = nums[queue.peekFirst()];
        //
        for(int i = k; i < n; i++){
            while(!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]){
                queue.pollLast();
            }
            queue.offerLast(i);
            while(queue.peekFirst() <= i - k){
                queue.pollFirst();
            }

            ans[i - k + 1] = nums[queue.peekFirst()];
        }

        return ans;
    }
}
