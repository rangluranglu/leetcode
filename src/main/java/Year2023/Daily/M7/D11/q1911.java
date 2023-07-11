package Year2023.Daily.M7.D11;

public class q1911 {
    public long maxAlternatingSum(int[] nums) {
        // 偶数下标尽可能大，奇数尽可能小
        // 状态dp
        int n = nums.length;
        long[][] dp = new long[n][2];
        // dp[0]最后下标为偶数的最大， dp[1]最后下标为奇数
        dp[0][0] = nums[0];
        dp[0][1] = 0;

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + nums[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] - nums[i], dp[i - 1][1]);
        }

        return dp[n - 1][0];
    }
}
