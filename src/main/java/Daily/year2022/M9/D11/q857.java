package Daily.year2022.M9.D11;

import java.util.Arrays;
import java.util.PriorityQueue;

public class q857 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        // 排序
        int n = quality.length;
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = Integer.valueOf(i);
        }
        // 按照权重升序排序
        Arrays.sort(index, (a, b) ->
                 quality[b] * wage[a] - quality[a] * wage[b]);

        double res = 1e9;
        double totalq = 0.0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k - 1; i++) {
            totalq += quality[index[i]];
            pq.offer(quality[index[i]]);
        }

        for(int i = k -1; i < n; i++){
            int idx = index[i];
            totalq += quality[idx];
            pq.offer(quality[idx]);

            double totalc = ((double) wage[idx] / quality[idx] * totalq);
            res = Math.min(res, totalc);
            totalq -= pq.poll();
        }

        return res;
    }
}
