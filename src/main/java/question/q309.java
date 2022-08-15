package question;

public class q309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 状态 0 持有， 1， 未持有，不在冷冻期， 2，冷冻期
        int dp[][] = new int[n][3];

        dp[0][0] = -prices[0];

        for(int i = 1; i < n; i++){
            // 状态转；
            // 持有
            dp[i][0] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][0]);
            // 没有持有
            dp[i][1] = Math.max(dp[i - 1][2], dp[i-1][1]);

            dp[i][2] = dp[i - 1][0] + prices[i];
        }

        return Math.max(dp[n-1][1], dp[n -1][2]);
    }

    public int maxProfit2(int[] prices) {
        // 空间优化

        int n = prices.length;
        // 状态 0 持有， 1， 未持有，不在冷冻期， 2，冷冻期
        int dp[] = new int[3];

        dp[0] = -prices[0];

        for(int i = 1; i < n; i++){
            // 状态转；
            // 持有
            int[] tmp = new int[3];
            tmp[0] = Math.max(dp[1] - prices[i], dp[0]);
            // 没有持有
            tmp[1] = Math.max(dp[2], dp[1]);

            tmp[2] = dp[0] + prices[i];

            dp = tmp;
        }

        return Math.max(dp[1], dp[2]);
    }
}
