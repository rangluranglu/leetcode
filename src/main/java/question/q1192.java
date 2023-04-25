package question;

import java.util.*;

public class q1192 {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // tarjan 模板题

        // 关键连接 --> 桥 无向图
        // tarjan 关键点
        // 1. 在 dfs 的过程中，记录每个节点初次被访问的时间戳
        // 2. 计算每个节点能访问到的节点的最小时间戳。

        // 建图
        List<Integer>[] graph = new List[n];
        Arrays.setAll(graph, e->new ArrayList<>());

        for(List<Integer> edge : connections){
            int x = edge.get(0), y = edge.get(1);
            graph[x].add(y);
            graph[y].add(x);
        }

        List<List<Integer>> ans = new ArrayList<>();
        int[] time = new int[n];  // dfs过程中， 初次访问的时间戳
        int[] low = new int[n];   // 每个节点的追溯值
        int[] num = {0};    // 自增数字用来给节点赋值;


        tarjan(0, 0, graph, time, low, ans, num);

        return ans;
    }

    private void tarjan(int u, int fa, List<Integer>[] graph, int[] time, int[] low, List<List<Integer>> ans, int[] num){
        // tarjan

        // 更新时间戳
        time[u] = low[u] = ++ num[0];

        for(int v : graph[u]){
            // dfs 发现新节点
            if(time[v] == 0){
                tarjan(v, u, graph, time, low, ans, num);

                // 更新父节点 追溯值
                low[u] = Math.min(low[u], low[v]);

                if (low[v] > time[u]){
                    // 有桥边
                    ans.add(Arrays.asList(u, v));
                }
            }else if(time[v] < time[u] && v != fa){
                // v在u之前已经访问过了
                // 无向图，u可以反向访问到其【dfs搜索树】父节点，跳过
                low[u] = Math.min(low[u], time[v]);

                // 这里为什么使用time[v]
            }
        }

    }
}
