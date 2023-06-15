package Year2023.Week.DW101;

import java.util.*;

public class q2608 {

    private List<Integer>[] g;
    private int[] dis;

    public int findShortestCycle(int n, int[][] edges) {
        // 环长度
        // 枚举起点 + bfs

        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());

        for(int[] e : edges){
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
        }

        dis = new int[n];

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, bfs(i));
        }

        return ans < Integer.MAX_VALUE ? ans : -1;
    }

    private int bfs(int start){
        // bfs
        int ans = Integer.MAX_VALUE;
        Arrays.fill(dis, -1);

        dis[start] = 0;

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start, -1});
        while (!q.isEmpty()){
            int[] p = q.poll();

            int x = p[0], fa = p[1];
            for(int y : g[x]){
                if(dis[y] < 0){
                    dis[y] = dis[x] + 1;
                    q.add(new int[]{y, x});
                }else if(y != fa){
                    ans = Math.min(ans, dis[x] + dis[y] + 1);
                }
            }
        }

        return ans;
    }
}
