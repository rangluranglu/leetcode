package Year2023.Week.W345;

public class q2684 {
    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        int[][] dp = new int[m][n];
        for(int j = 1; j < n; j++){
            int cur = 0;
            for (int i = 0; i < m; i++) {
                if(grid[i][j] > grid[i][j - 1]){
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + 1);
                }

                if(i + 1 < m && grid[i][j] > grid[i + 1][j - 1]){
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 1);
                }

                if(i - 1 >= 0 && grid[i][j] > grid[i - 1][j -1]){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
                cur = Math.max(cur, dp[i][j]);
            }
            ans = Math.max(cur, ans);

            if(cur < j){
                return ans;
            }
        }

        return ans;
    }
}
