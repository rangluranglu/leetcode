package Year2023.Week.DW102;

import java.util.Arrays;

public class q2642 {
}


class Graph {

    private static final int INF = Integer.MAX_VALUE / 2;

    int n;


    private int[][] g;
    public Graph(int n, int[][] edges) {
        // n个节点有向带权图，
        this.n = n;
        this.g = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i], INF);
        }

        for(int[] e : edges){
            g[e[0]][e[1]] = e[2];
        }
    }

    public void addEdge(int[] edge) {
        g[edge[0]][edge[1]] = edge[2];
    }

    public int shortestPath(int node1, int node2) {
        // Dijkstra 算法
        int[] dis = new int[n];
        Arrays.fill(dis, INF);
        dis[node1] = 0;
        boolean[] vis = new boolean[n];

        for (;;){
            // 找到当前最短路径
            int x = -1;
            for (int i = 0; i < n; i++) {
                if(!vis[i] && (x < 0 || dis[i] < dis[x])){
                    x = i;
                }
            }

            if (x < 0 || dis[x] == INF){
                return -1;
            }

            if(x == node2){
                return dis[x];
            }

            vis[x] = true;
            for(int y = 0; y < n; y++){
                dis[y] = Math.min(dis[y], dis[x] + g[x][y]);
            }
        }


    }
}