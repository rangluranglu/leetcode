package Year2023.Week.W338;

import java.util.*;

public class q2603 {
    public int collectTheCoins(int[] coins, int[][] edges) {
        //  n - 1 的edges ，
        // 选择 收集当前节点距离为2以内的所以金币
        // 移动到相邻节点

        // 收集所有金币， 返回出发节点， 返回最少经过的边数

        // 拓扑排序 + 记录入队时间

        // topic1 : 去掉不包含金币的子树
        // topic2 : 只需要考虑有金币的叶子
        // topic3 : 从有金币的的叶子出发，再次跑拓扑排序。在拓扑排序的同时，标记每个点入队的时间time。

        int n = coins.length;
        List<Integer>[] g = new ArrayList[n];

        Arrays.setAll(g, e -> new ArrayList<>());
        int[] deg = new int[n];

        for(int[] edge : edges){
            int x = edge[0], y = edge[1];
            g[x].add(y);
            g[y].add(x);

            deg[x] ++;
            deg[y] ++;
        }

        // 拓扑排序
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if(deg[i] == 1 && coins[i] == 0){
                // 无金币叶子
                q.add(i);
            }
        }

        while (!q.isEmpty()){
            int x = q.pop();
            for(int y : g[x]){
                if(--deg[y] == 1 && coins[y] == 0){
                    q.add(y);
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(deg[i] == 1 && coins[i] == 1){
                // 有金币叶子
                q.add(i);
            }
        }

        if(q.size() <= 1) return 0;

        int[] time = new int[n];

        while (!q.isEmpty()){
            int x = q.pop();

            for(int y : g[x]){
                if(--deg[y] == 1){
                    time[y] = time[x] + 1;
                    q.add(y);
                }
            }
        }

        int ans = 0;
        for(int[] e : edges){
            if(time[e[0]] >= 2 && time[e[1]] >= 2){
                ans += 2;
            }
        }

        return ans;


    }
}
