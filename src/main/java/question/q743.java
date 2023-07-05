package question;

import java.util.Arrays;

public class q743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        // dij  有向
        int INF = Integer.MAX_VALUE / 2;
        int[][] g = new int[n][n];

        for(int[] e : g){
            Arrays.fill(e, INF);
        }

        for(int[] time : times){
            g[time[0] - 1][time[1] - 1] = time[2];
        }

        int[] dis = new int[n];
        Arrays.fill(dis, INF);
        dis[k - 1] = 0;

        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            int x = -1;

            for(int j = 0; j < n; j++){
                if(!vis[j] && (x == -1 || dis[j] < dis[x])){
                    x = j;
                }
            }

            vis[x] = true;
            // 更新之后的节点

            for(int j = 0; j < n; j++){
                dis[j] = Math.min(dis[j], dis[x] + g[x][j]);
            }
        }

        int max = Arrays.stream(dis).max().getAsInt();

        return max == INF ? -1 : max;
    }
}
