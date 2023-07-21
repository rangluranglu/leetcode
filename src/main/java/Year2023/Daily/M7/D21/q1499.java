package Year2023.Daily.M7.D21;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class q1499 {
    public int findMaxValueOfEquation(int[][] points, int k) {
        // 满足不等式的最大值
        // 找到 yi + yj + |xi - xj| 的最大值，其中 i < j 且 |xi - xj| <= k
        // max(yi + yj + xj - xi), xj - xi <= k

        int max = Integer.MIN_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int[] p : points){
            int x = p[0], y = p[1];

            while (!pq.isEmpty() && x - pq.peek()[1] > k){
                pq.poll();
            }

            if(!pq.isEmpty()){
                max = Math.max(max, pq.peek()[0] + x + y);
            }

            pq.offer(new int[]{y - x, x});
        }

        return max;
    }

    public int findMaxValueOfEquation2(int[][] points, int k) {
        // 双端队列
        int ans = Integer.MIN_VALUE;

        Deque<int[]> queue = new ArrayDeque<>();
        for(int[] point : points){
            int x = point[0], y = point[1];
            while (!queue.isEmpty() && x - queue.peekFirst()[1]> k){
                queue.pollFirst();
            }

            if(!queue.isEmpty()){
                ans = Math.max(ans, queue.peekFirst()[0] + x + y);
            }

            while (!queue.isEmpty() && queue.peekLast()[0] <= y - x){
                queue.pollLast();
            }

            queue.offerLast(new int[]{y - x, x});
        }
        return ans;
    }
}
