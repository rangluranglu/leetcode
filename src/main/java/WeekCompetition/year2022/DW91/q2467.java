package WeekCompetition.year2022.DW91;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q2467 {
    int[] bobTime;
    int[] amount;
    int ans = Integer.MIN_VALUE;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        // dfs
        // 首先计算 bob到0 路径上的时间点
        // 从0 到每个叶子节点， 计算amount

        int n = amount.length;
        List<Integer>[] g = new ArrayList[n];
        bobTime = new int[n];
        Arrays.fill(bobTime, n);
        this.amount = amount;

        // 邻接表
        Arrays.setAll(g, a -> new ArrayList<>());

        for(int[] edge : edges){
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }

        dfsBob(g, bob, -1, 0);
        System.out.println(Arrays.toString(bobTime));
        g[0].add(-1);
        dfsA(g, 0, -1, 0, 0);
        return ans;
    }

    private boolean dfsBob(List<Integer>[] g, int now, int prev, int time){
        if(now == 0){
            // 到达0点
            bobTime[now] = time;
            return true;
        }

        for(int e : g[now]){
            if(e != prev && dfsBob(g, e, now, time + 1)){
                bobTime[now] = time;
                return true;
            }
        }
        return false;
    }

    private void dfsA(List<Integer>[] g, int now, int prev, int time, int total){
        if(bobTime[now] == time){
            // 相遇， 平分分数
            total += amount[now] / 2;
        }else if(bobTime[now] > time){
            total += amount[now];
        }

        if(g[now].size() == 1){
            // 叶子节点
            ans = Math.max(ans, total);
            return;
        }

        for(int e : g[now]){
            if(e != prev){
                dfsA(g, e, now, time + 1, total);
            }
        }
    }
}
