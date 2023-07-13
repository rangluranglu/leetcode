package Year2023.Daily.M7.D13;

public class q931 {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        // 动态规划

        int[][] dp = new int[m][n];

        for(int i = 0; i < n; i++){
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], Math.min(j > 0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE, j < n - 1 ? dp[i-1][j + 1] : Integer.MAX_VALUE)) + matrix[i][j];
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[m - 1][i]);
        }

        return ans;
    }
}
