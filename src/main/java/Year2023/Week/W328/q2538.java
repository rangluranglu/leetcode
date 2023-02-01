package Year2023.Week.W328;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q2538 {
    private List<Integer>[] g;
    private int[] price;
    private long ans;

    public long maxOutput(int n, int[][] edges, int[] price) {
        // 开销 = 最大和 - 最小和

        // 树形DP
        // 最小的一条路径一定只有一个点
        // 价值和最大的一条路径与最小的一条路径的差值 等价于 去掉路径的一个端点
        // 问题转换成去掉一个叶子后的最大路径和（这里的叶子严格来说是度为 1 的点，因为根的度数也可能是 1）。
        this.price = price;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());

        for(int[] edge : edges){
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }

        dfs(0, -1);
        return ans;
    }

    // 返回带叶子节点的最大路径和， 不带叶子节点的最大路径和
    private long[] dfs(int x, int fa){
        long p = price[x], maxS1 = p, maxS2 = 0;
        for(Integer y : g[x]){
            if(y != fa){
                long[] res = dfs(y, x);

                long s1 = res[0], s2 = res[1];
                // 前面最大带叶子的路径和 + 当前不带叶子的路径和
                // 前面最大不带叶子的路径和 + 当前带叶子的路径和
                ans = Math.max(ans, Math.max(maxS1 + s2, maxS2 + s1));

                maxS1 = Math.max(maxS1, s1 + p);
                maxS2 = Math.max(maxS2, s2 + p);
            }
        }

        return new long[]{maxS1, maxS2};

    }
}
