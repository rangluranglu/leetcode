package question;

public class offer47 {
    public int maxValue(int[][] grid) {
        // 动态规划

        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++) {
                dp[i][j] = grid[i - 1][j - 1] + Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m][n];
    }
}
