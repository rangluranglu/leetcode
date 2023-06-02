package Year2023.Week.DW99;

import java.util.*;

public class q2581 {

    private List<Integer>[] g;
    private int k, ans, cnt0;

    private Set<Long> s = new HashSet<>();
    public int rootCount(int[][] edges, int[][] guesses, int k) {
        // 换根DP
        // 如果节点 x 和 y 之间有边，那么从「以 x 为根的树」变成「以 y 为根的树」，就只有 [x,y] 和 [y,x] 这两个猜测的正确性变了

        // 从0开始dfs这棵树， x ->
        // 如果有猜测 [x,y]，那么猜对次数减一；
        // 如果有猜测 [y,x]，那么猜对次数加一。

        this.k = k;
        g = new List[edges.length + 1];
        Arrays.setAll(g, e-> new ArrayList<>());

        for(int[] edge : edges){
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }


        // 将guess 转成哈希表
        for(int[] e : guesses){
            s.add((long) e[0] << 32| e[1]);
        }

        dfs(0, -1);
        reroot(0, -1, cnt0);

        return ans;
    }

    private void dfs(int x, int fa){
        for(int y : g[x]){
            if(y != fa){
                if(s.contains((long) x << 32 | y)){
                    // 以0为根时猜对了
                    cnt0 ++;
                }
                dfs(y, x);
            }
        }
    }

    private void reroot(int x, int fa, int cnt){
        // cnt 是x为根的数
        if(cnt >= k){
            ans ++;
        }

        for(int y : g[x]){
            if(y != fa){
                int c = cnt;
                if(s.contains((long) x << 32 | y)){
                    c--;
                }

                if(s.contains((long) y << 32 | x)){
                    c ++;
                }

                reroot(y, x, c);
            }
        }
    }
}
