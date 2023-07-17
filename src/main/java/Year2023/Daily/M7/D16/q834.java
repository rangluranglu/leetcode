package Year2023.Daily.M7.D16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q834 {

    private List<Integer>[] g;
    private int[] ans, size;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        // n个节点， n-1 条边
        // 换根dp
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());

        for(int[] e : edges){
            int x =e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
        }

        ans = new int[n];
        size = new int[n];

        dfs(0, -1, 0);
        reroot(0, -1);

        return ans;

    }


    private void dfs(int x, int fa, int depth){
        ans[0] += depth;
        size[x] = 1;

        for(int y : g[x]){
            if(y != fa){
                dfs(y, x, depth + 1);
                size[x] += size[y];
            }
        }

    }

    private void reroot(int x, int fa){
        for(int y : g[x]){
            if(y != fa){
                ans[y] = ans[x] + g.length - 2 * size[y];
                reroot(y, x);
            }
        }
    }
}
