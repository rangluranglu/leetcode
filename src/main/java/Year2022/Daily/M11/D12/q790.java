package Year2022.Daily.M11.D12;

public class q790 {
    int MOD = (int) 1e9 + 7;
    public int numTilings(int n) {
        // dp  有四种状态
        int[][] dp = new int[n + 1][4];
        // 初始化
        dp[0][3] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][3];
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
            dp[i][3] = (((dp[i - 1][0] + dp[i - 1][1]) % MOD + dp[i - 1][2]) % MOD+ dp[i - 1][3]) % MOD;

        }

        return dp[n][3];
    }
}
