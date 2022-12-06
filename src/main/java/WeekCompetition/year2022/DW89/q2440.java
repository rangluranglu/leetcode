package WeekCompetition.year2022.DW89;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q2440 {
    private List<Integer>[] g;
    private int[] nums;
    private int target;


    public int componentValue(int[] nums, int[][] edges) {
        // 枚举连通块的个数为i， 则删除边数为 i - 1
        //如果价值超过 target，那么当前删边方案不合法，返回 −1。
        //如果价值等于 target，找到了一个连通块，和其父节点断开，返回 0。
        //如果价值小于 target，尚未找到一个完整的连通块，返回价值。

        int n = nums.length;

        g = new ArrayList[n];
        this.nums = nums;

        Arrays.setAll(g, a -> new ArrayList<>());

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];

            g[x].add(y);
            g[y].add(x);
        }

        int sum = Arrays.stream(nums).sum();
        int max = Arrays.stream(nums).max().getAsInt();

        // i最多分为的块数
        for(int i = sum / max; ;i--){
            if(sum % i == 0){
                target = sum / i;
                if(dfs(0, -1) == 0){
                    return i - 1;
                }
            }
        }
    }

    private int dfs(int x, int fa){
        int sum = nums[x];

        for(int y : g[x]){
            if(y != fa){
                int res = dfs(y, x);
                if(res < 0){
                    return -1;
                }
                sum += res;
            }
        }

        if(sum > target){
            return -1;
        }

        return sum < target ? sum : 0;
    }
}
