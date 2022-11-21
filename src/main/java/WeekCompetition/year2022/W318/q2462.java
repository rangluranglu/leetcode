package WeekCompetition.year2022.W318;

import java.util.Arrays;
import java.util.PriorityQueue;

public class q2462 {
    public long totalCost(int[] costs, int k, int candidates) {
        // 判断 candidates * 2 >= len 时， 排序
        int len = costs.length;
        long ans = 0;
        if(candidates * 2 >= costs.length){
            Arrays.sort(costs);

            for (int i = 0; i < k; i++) {
                ans += costs[i];
            }

            return ans;
        }

        // 最小堆
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> {
            return costs[a] != costs[b] ? costs[a] - costs[b] : a - b;
        });


        for (int i = 0; i < candidates; i++) {
            q.offer(i);
            q.offer(len - 1 - i);
        }

        // 双指针
        for (int l = candidates, r = len - candidates - 1; k > 0; k --) {
            int can = q.poll();

            ans += costs[can];
            if(l <= r){
                q.offer(can < l ? l ++ : r --);
            }
        }

        return ans;
    }
}
