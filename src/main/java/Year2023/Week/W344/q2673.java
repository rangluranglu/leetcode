package Year2023.Week.W344;

public class q2673 {
    public int minIncrements(int n, int[] cost) {
        // 满二叉树， 有cost[i] 是第i+1 个节点的值节点的值
        // 和相等，

        // 不是叶子节点的兄弟节点：从根到当前节点的路径，除了这两个兄弟节点不一样，其余节点都一样。

        int ans = 0;

        for(int i = n / 2; i > 0; i--){
            // 转着 2 * i - 1 , 2 * i
            ans += Math.abs(cost[2 * i - 1] - cost[2 * i]); // 子节点
            cost[i - 1] += Math.max(cost[i*2 - 1], cost[2 * i]); // 累加路径和
        }

        return ans;
    }
}
