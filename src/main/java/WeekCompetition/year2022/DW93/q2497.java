package WeekCompetition.year2022.DW93;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class q2497 {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n = vals.length;

        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, a -> new ArrayList<>());
        for(int[] edge : edges){
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // 至多包含k条边
            int tmep = vals[i];
            Collections.sort(g[i], (a, b) -> (vals[b] - vals[a]));
            for(int j = 0; j < Math.min(k, g[i].size()) ; j++){
                if(vals[g[i].get(j)] < 0){
                    break;
                }
                tmep += vals[g[i].get(j)];
            }
            ans = Math.max(ans, tmep);


        }

        return ans;
    }
}
