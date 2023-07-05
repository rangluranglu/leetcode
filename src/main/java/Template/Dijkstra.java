package Template;

import java.util.*;

public class Dijkstra {
    // 最短路径
    // 朴素版 - dijkstra 算法， 适用于有向稠密图
    // O(n ^ 2)
    public int simpleDijkstra(int[][] edges, int start, int end){
        // 建图 -- 领接矩阵
        int n = edges.length;

        // g用来保存点到点的最短距离
        int[][] g = new int[n][n];
        int INF = Integer.MAX_VALUE / 2;
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i], INF);
        }

        for(int[] e : edges){
            g[e[0]][e[1]] = e[2];
        }

        // 保存最短距离
        int[] dis = new int[n];
        Arrays.fill(dis, INF);
        dis[start] = 0;

        boolean[] vis = new boolean[n];

        // 也可以用 for(int i < 0; i < n; i++) 全部遍历，
        // 因为可以提前找到答案，所以可以用 f(;;)
        for(;;){

            // 找到当前最短路径，去更新邻居的最短路径
            // dis[x] 是最短长度
            int x = -1;
            for(int i = 0; i < n; i++){
                if(!vis[x] && (x < 0 || dis[i] < dis[x])){
                    x = i;
                }
            }

            // 所有从start能达到的节点都被更新过了
            if(x < 0 || dis[x] == INF){
                return -1;
            }

            if(x == end){
                // 找到终点
                return dis[end];
            }

            // 更新相邻节点
            vis[x] = true;
            for(int y = 0; y < n; y++){
                dis[y] = Math.min(dis[y], dis[x] + g[x][y]);
            }
        }

    }


    // 堆优化dijkstra 算法
    public int stackDijkstra(int[][] edges, int start, int end){
        int n = edges.length;

        // g用来保存点到点的最短距离
        int[][] g = new int[n][n];
        int INF = Integer.MAX_VALUE / 2;
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i], INF);
        }

        for(int[] e : edges){
            g[e[0]][e[1]] = e[2];
        }

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);

        int[] dis = new int[n];
        Arrays.fill(dis, INF);
        dis[start] = 0;

        pq.add(new int[]{start, 0});


        while (!pq.isEmpty()){
            // 最短路径
            int[] node = pq.poll();
            if(dis[node[0]] < node[1]){
                continue;
            }

            if(node[0] == end){
                return dis[end];
            }

            for (int i = 0; i < n; i++) {
                if(g[node[0]][i] + node[1] < dis[i]){
                    dis[i] = g[node[0]][i] + node[1];
                    pq.offer(new int[]{i, dis[i]});
                }
            }
        }

        return dis[end];
    }
}
