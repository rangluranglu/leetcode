package Year2022.Daily.M12.D5;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class q1687 {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        // 按顺序处理数组 -->处理boxes的顺序已经固定
        // 最少行程 --> 不一定是装满最好

        // 可以dfs， 动态规划？ dp[i] --> 前i个箱子最小行程数
        // 转移？ --> dp[i] = dp[i -1] + cost[j, i] (i - maxB + 1 <= j <= i)
        // 渐渐复杂度 O(n * 3)
        int n = boxes.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = i; j >= 1 && j >= i - maxBoxes + 1; j--){
                sum += boxes[j - 1][1];  // 累加箱子重量;
                if(sum > maxWeight){
                    break;
                }

                dp[i] = Math.min(dp[i], dp[j - 1] + cost(boxes, j, i));
            }

        }

        return dp[n];
    }

    public int boxDelivering2(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        // 优化 --> 可以看做是滑动窗口，求最小值
        // 使用 diff 来表示cost的差异值,若前一个箱子i−1于当前箱子i的码头相同，那么并不会增加运输次数，那么这次的dif为0，否则就会增加1。

        // 渐渐复杂度 O(n)
        int n = boxes.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        Deque<int[]> q = new ArrayDeque<>();
        int diff = 0, wei = 0;

        for (int i = 1; i <= n; i++) {
            int cur = dp[i - 1] + 2; // cur为每次滑动窗口增加的值即dp[i-1]+cost[i,i] , 右端点
            diff += i >= 2 && boxes[i - 1][0] != boxes[i - 2][0] ? 1 : 0; // 计算diff，由于我们无法直接在队列中进行修改，那么可以考虑增加一个累加值
            wei += boxes[i - 1][1]; // 加上当前箱子的重量；
            // 递增的 q
            while (!q.isEmpty() && q.peekLast()[1] + diff >= cur){
                q.pollLast();
            }
            // a,b,c, 其中a为该点的编号用来判断是否在窗口外，b为当前值的行程数，c为当前的重量之和。
            // 减去一个dif是因为队列中保存的是一个相对的运输次数。
            q.add(new int[]{i, cur - diff, boxes[i - 1][1] - wei});
            //判断左端队头是否在窗口外 并且重量不能超过最大重量
            while (q.peekFirst()[0] <= i - maxBoxes || q.peekFirst()[2] + wei > maxWeight) q.pollFirst();
            dp[i] = q.peekFirst()[1] + diff;

        }

        return dp[n];
    }


    private int cost(int[][] boxes, int l, int r){
        int ans = 2;
        int port = boxes[l - 1][0];

        while (++l <= r){
            if(boxes[l - 1][0] == port){
                continue;
            }

            ans++;
            port = boxes[l - 1][0];
        }

        return ans;
    }
}
