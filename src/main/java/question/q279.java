package question;

public class q279 {
    public int numSquares(int n) {
        // 和为n最少数量
        // dp 背包问题 1 到 100；
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i ++){
            int minn = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++){
                minn = Math.min(minn, dp[i - j * j]);
            }
            dp[i] = minn + 1;
        }
        return  dp[n];
    }
}
