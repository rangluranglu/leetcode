package Year2023.Daily.M7.D28;

import java.util.*;

public class q2050 {
    List<Integer>[] g;
    public int minimumTime(int n, int[][] relations, int[] time) {
        // 2050.并行课程

        g = new List[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        // 入度
        int[] ind = new int[n];
        // 有向图
        for(int[] rela : relations){
            g[rela[0] - 1].add(rela[1] - 1);
            ind[rela[1] - 1] ++;
        }
        int ans = 0;

        // 拓扑排序
        Deque<Integer> queue = new ArrayDeque<>();
        // 每个课程学完所花费的最少月份
        int[] finishTime = new int[n];

        for(int i = 0; i < n; i++){
            if(ind[i] == 0){
                queue.offer(i);
                finishTime[i] = time[i];
            }
        }

        while (!queue.isEmpty()){
            int cur = queue.poll();
            ans = Math.max(ans, finishTime[cur]);

            for(int next : g[cur]){
                ind[next] --;
                finishTime[next] = Math.max(finishTime[next], finishTime[cur] + time[next]);
                if(ind[next] == 0){
                    queue.offer(next);
                }
            }
        }
        return ans;

    }
}
