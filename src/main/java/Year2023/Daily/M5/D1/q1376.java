package Year2023.Daily.M5.D1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public class q1376 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // dfs

        List<Integer>[] edges = new List[n];

        Arrays.setAll(edges, e -> new ArrayList<>());

        for(int i = 0; i < n; i ++){
            if(i != headID){
                edges[manager[i]].add(i);
            }
        }

        return dfs(edges, headID, informTime);
    }


    public int dfs(List<Integer>[] edges, int node, int[] informTime){

        int ans = 0;

        for(int ne : edges[node]){
            ans = Math.max(ans, dfs(edges, ne, informTime));
        }

        return informTime[node] + ans;

    }
}
