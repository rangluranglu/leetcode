package question;

public class q122 {
    public int maxProfit(int[] prices) {
        // 动态规划
        int n = prices.length;
        // dp[i][0] 没有股票
        // dp[i][1] 有股票

        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[1]);
        }

        return dp[n - 1][0];
    }

    public int maxProfit2(int[] prices) {
        // 贪心
        int ans = 0;
        int n = prices.length;

        for (int i = 0; i < n; i++) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }

        return ans;
    }
}
