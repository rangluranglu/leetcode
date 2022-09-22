package question;

import java.util.Arrays;
import java.util.PriorityQueue;

public class q1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // 升序保存结束时间， 找到当前时间可得报酬

        int n = startTime.length;
        // 按照结束时间排序的小顶堆
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Integer[] index = new Integer[n];
        for(int i = 0; i < n; i ++){
            index[i] = i;
        }
        // 开始时间递增
        Arrays.sort(index, (a, b) -> startTime[a] - startTime[b]);
        int max = 0;
        for (int i = 0; i < n; i++) {
            int start = startTime[index[i]];

            // 取出结束时间小于等于当前start的工作
            while (!pq.isEmpty() && pq.peek()[1] <= start){
                max = Math.max(max, pq.poll()[0]);
            }

            // 当前最大受益 + 结束时可得受益
            pq.offer(new int[]{max + profit[index[i]], endTime[index[i]]});
        }

        while (!pq.isEmpty()){
            max = Math.max(max, pq.poll()[0]);
        }

        return max;

    }
}
