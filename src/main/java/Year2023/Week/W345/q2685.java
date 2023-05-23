package Year2023.Week.W345;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q2685 {

    private List<Integer>[] g;
    private boolean vis[];
    private int v, e;
    public int countCompleteComponents(int n, int[][] edges) {
        // dfs连通块， 统计点数v和边数e
        g = new ArrayList[n];

        Arrays.setAll(g, e -> new ArrayList<>());

        for(int[] e : edges){
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
        }

        int ans = 0;
        vis = new boolean[n];

        for(int i = 0; i <n; i++){
            if(!vis[i]){
                v = 0;
                e = 0;
                dfs(i);
                if(e == v*(v-1)){
                    ans ++;
                }
            }
        }

        return ans;
    }

    private void dfs(int x){
        vis[x] = true;
        v ++;
        e += g[x].size();

        for(int y : g[x]){
            if(!vis[y]){
                dfs(y);
            }
        }
    }
}
