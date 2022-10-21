package WeekCompetition.year2022.W314;

public class q2435 {
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int mod = (int) 1e9 + 7;

        int[][][] dp = new int[m + 1][n + 1][k];

        // 初始化 重要
        dp[0][1][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int v = 0; v < k; v++) {
                    dp[i + 1][j + 1][(v + grid[i][j]) % k] = (dp[i + 1][j][v] + dp[i][j + 1][v]) % mod;

                }
            }
        }

        // grid[0][0] < k 的情况
        return dp[m][n][0];

    }
}
