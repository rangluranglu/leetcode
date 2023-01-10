package Year2023.Week.W327;

import java.util.PriorityQueue;

public class q2530 {
    public long maxKelements(int[] nums, int k) {
        // 大顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for(int num : nums){
            pq.offer(num);
        }

        long ans = 0L;
        while (k -- > 0){
            int num = pq.poll();
            ans += num;

            pq.offer((num + 2) / 3); // 向上取整
        }

        return ans;
    }

}
