package Year2023.Week.W341;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class q2646 {

    private List<Integer>[] g;
    private int[] price, cnt;
    private int end;


    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        // n个节点
        // 暴力DFS
        // 计算登录次数， cnt[x]

        // price[x] 不变， price[y] 减半
        // price[x] 减半， price[y] 不减

        g = new List[n];
        Arrays.setAll(g, e -> new ArrayList<>());

        for(int[] edge : edges){
            int x= edge[0], y =edge[1];
            g[x].add(y);
            g[y].add(x);
        }

        this.price = price;

        cnt = new int[n];

        for(int[] t : trips){
            end = t[1];
            path(t[0], -1);
        }
        System.out.println(Arrays.toString(cnt));
        int[] p = dfs(0, -1);
        return Math.min(p[0], p[1]);

    }

    private boolean path(int x, int fa){
        if(x == end){ // 注意：重要：树只有唯一的一条简单路径 ！！！
            // 到达终点
            cnt[x] ++;  // 统计从start到end的路径上的点经过了多少次
            return true; // 找到终点
        }

        for(int y : g[x]){
            // 是树，只有两个节点，所以只需要考虑父节点
            if(y != fa && path(y, x)){
                cnt[x] ++;  // 统计从 start 到 end 的路径上的点经过了多少次
                return true;  // 找到终点
            }
        }

        return false;
    }

    private int[] dfs(int x, int fa){
        int notHalf = price[x] * cnt[x];
        int halve = notHalf / 2;

        for(int y : g[x]){
            if(y != fa){
                int[] p = dfs(y, x);
                notHalf += Math.min(p[0], p[1]);
                halve += p[0];
            }

        }

        return new int[]{notHalf, halve};
    }


    public int minimumTotalPrice2(int n, int[][] edges, int[] price, int[][] trips) {
        // n个节点
        // 价格总和，  第一次旅行前 ，选择一些非相邻节点价格减半

        // Tarjan 离线LCA + 树上差分
        // x 到 y --> 经过 LCA(最近公共祖先)
        // 路径为 x - lca` - lca - y   其中 lca` 是lca的儿子
        // （x - lca`) + (y - lca)

        // 更新差分
        // 对于 x - lca`  diff[x] +1, diff[lca] -1
        //

        // todo
        return 0;
    }
}
