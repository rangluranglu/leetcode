package WeekCompetition.year2022.W310;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class q2406 {
    public int minGroups(int[][] intervals) {
        // 排序 起始递增
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // 小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] p : intervals){
            if(!pq.isEmpty() && pq.peek() < p[0]){
                pq.poll();
            }

            pq.offer(p[1]);
        }

        return pq.size();
    }
}
