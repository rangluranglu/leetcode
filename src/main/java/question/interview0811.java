package question;

public class interview0811 {
    public int waysToChange(int n) {
        int Mod = (int) 1e9 + 7;
        int[] coins = {1, 5, 10, 25};
        // dp 25 10 5 1
        // 完全背包问题

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 0; i < 4; i++){
            int coin = coins[i];
            for(int j = coin; j <= n; j++){
                dp[j] = (dp[j] + dp[j - coin]) % Mod;
            }
        }

        return dp[n];
    }
}
