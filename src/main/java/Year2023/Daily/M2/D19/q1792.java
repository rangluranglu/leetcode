package Year2023.Daily.M2.D19;

import java.util.PriorityQueue;

public class q1792 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // 贡献 i
        // passi + 1/ totali + 1 - passi/totali < passj + 1/ totalj + 1 - passj/totalj
        // j比i优先级更高， 化简
        // (totali + 1) * (totali) * (totalj - passj) > (totalj + 1) * (totalj) * (totali - passi)

        // 优先队列
        // 大顶
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
            long val1 = (long) (b[1] + 1) * b[1] * (a[1] - a[0]);
            long val2 = (long) (a[1] + 1) * a[1] * (b[1] - b[0]);

            if(val1 == val2){
                return 0;
            }

            return val2 > val1 ? 1 : -1;
        });

        for(int[] c : classes){
            pq.offer(c);
        }

        for (int i = 0; i < extraStudents; i++) {
            int[] arr = pq.poll();
            int pass = arr[0], totoal = arr[1];
            pq.offer(new int[]{pass + 1, totoal + 1});
        }

        double res = 0;

        for (int i = 0; i < classes.length; i++) {
            int[] arr = pq.poll();
            int pass = arr[0], total = arr[1];
            res += 1.0 * pass / total;
        }

        return res / classes.length;
    }
}
