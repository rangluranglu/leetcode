package question;

import java.util.Arrays;

public class q518 {
    public static void main(String[] args) {
        int[] coins = {3};
        System.out.println(change(2, coins));
    }
    public static int change(int amount, int[] coins) {
        int n = coins.length;
        // 完全背包问题
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int i = 0; i < n; i++){
            int coin = coins[i];
            for(int j = coin; j <= amount; j++){
                dp[j] = dp[j - coin] + dp[j];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }
}
