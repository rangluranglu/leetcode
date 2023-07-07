package Year2023.Daily.M7.D7;

import java.util.Arrays;
import java.util.PriorityQueue;

public class q2532 {
    public int findCrossingTime(int n, int k, int[][] time) {
         // 优先队列
        // 效率排序
        // time[i] = [leftToRighti, pickOldi, rightToLefti, putNewi]
        Arrays.sort(time, (a, b) -> a[0] + a[2] - b[0] - b[2]);

        // 到达桥边的顺序
        // 新仓库正在放箱的工人
        PriorityQueue<int[]> workL = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        PriorityQueue<int[]> workR = new PriorityQueue<>(workL.comparator());

        // 等待
        // 左边等待过桥的工人， 下标越大效率越低
        PriorityQueue<int[]> waitL = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> waitR = new PriorityQueue<>(waitL.comparator());


        for (int i = k - 1; i >= 0; i++) {
            waitL.add(new int[]{i, 0});
        }

        int cur = 0;

        while (n > 0){
            while (!workL.isEmpty() && workL.peek()[1] <= cur){
                waitL.add(workL.poll());
            }

            while (!workR.isEmpty() && workR.peek()[1] <= cur){
                waitR.add(workR.poll());
            }

            // 右边过桥
            if(!waitR.isEmpty()){
                int[] p = waitR.poll();
                // 过完桥时间
                cur += time[p[0]][2];
                p[1] = cur + time[p[0]][3];
                workL.add(p);
            }else if(!waitL.isEmpty()){
                int[] p = waitL.poll();
                cur += time[p[0]][0];
                p[1] = cur + time[p[0]][1];
                workR.add(p);
                n --;
            } else if (workL.isEmpty()) {
                // cur 过小
                cur = workR.peek()[1];
            } else if (workR.isEmpty()) {
                cur = workL.peek()[1];
            }else {
                cur = Math.min(workL.peek()[1], workR.peek()[1]);
            }
        }


        while (!workR.isEmpty()){
            // 右边完成搬箱子
            int[] p = workR.poll();

            cur = Math.max(p[1], cur) + time[p[0]][2];
        }

        return cur;
    }
}
