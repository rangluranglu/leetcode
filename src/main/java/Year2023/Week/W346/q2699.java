package Year2023.Week.W346;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q2699 {
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        // 无向带权图

        // Dijkstra

        List<int[]> g[] = new ArrayList[n];
        Arrays.setAll(g, e-> new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0], y = edges[i][1];
            g[x].add(new int[]{y, i}); // 记录编号
            g[y].add(new int[]{x, i});
        }

        int[][] dis = new int[n][2];

        for (int i = 0; i < n; i++) {
            if(i != source){
                dis[i][0] = dis[i][1] = Integer.MAX_VALUE;
            }
        }

        dijkstra(g, edges, destination, dis, 0, 0);

        int delta = target - dis[destination][0];
        if(delta < 0){
            return new int[][]{};
        }
        dijkstra(g, edges, destination, dis, delta, 1);
        if(dis[destination][1] < target){
            return new int[][]{};
        }
        for(int[] e : edges){
            if(e[2] == -1){
                e[2] = 1;
            }
        }

        return edges;
    }


    private void dijkstra(List<int[]>[] g, int[][] edges, int destination, int[][] dis, int delta, int k){
        int n = g.length;

        boolean[] vis = new boolean[n];
        for (;;){
            // 找最短路径

            int x = -1;
            for (int i = 0; i < n; i++) {
                if(!vis[i] && (x < 0 || dis[i][k] < dis[x][k])){
                    x = i;
                }
            }
            if(x == destination){
                return;
            }

            vis[x] = true;
            for(int[] e : g[x]){
                int y = e[0], eid = e[1];
                int wt = edges[eid][2];
                if(wt == -1){
                    wt = 1;
                }

                if(k == 1 && edges[eid][2] == -1){
                    // 第二轮
                    int w = delta + dis[y][0] - dis[x][1];
                    if(w > wt){
                        edges[eid][2] = wt = w;
                    }
                }

                dis[y][k] = Math.min(dis[y][k], dis[x][k] + wt);
            }
        }

    }
}
