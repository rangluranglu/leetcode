package Year2023.Daily.M5.D24;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q1377 {
    List<Integer>[] g;
    boolean[] seen;
    public double frogPosition(int n, int[][] edges, int t, int target) {
        g = new ArrayList[n + 1];
        Arrays.setAll(g, a -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
        }
        seen = new boolean[n + 1];
        // dfs 找到路径 path
        return dfs(1, t, target);

    }


    private double dfs(int i, int t, int target){

        int next = i == 1? g[i].size() : g[i].size() - 1;
        if(t == 0 || next == 0){
            return i == target ? 1.0 : 0.0;
        }

        seen[i] = true;
        double ans = 0.0;
        for(int j : g[i]){
            if(!seen[j]){
                ans += dfs(j, t - 1, target);
            }
        }

        return ans / next;


    }
}
