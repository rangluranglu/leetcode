package Year2023.Daily.M8.D10;

public class q1289 {
    public int minFallingPathSum(int[][] grid) {
        // 下降路径
        int m = grid.length, n = grid[0].length;

        int mn = Integer.MAX_VALUE, mn2 = Integer.MAX_VALUE;
        int[][] dp = new int[m][n];
        for(int i = 0; i < n; i++){
            dp[0][i] = grid[0][i];
            if(dp[0][i] < mn){
                mn2 = mn;
                mn = dp[0][i];
            }else if(dp[0][i] < mn2){
                mn2 = dp[0][i];
            }
        }

        for(int i = 1; i < m; i++){
            int tmn = Integer.MAX_VALUE, tmn2 = Integer.MAX_VALUE;
            for(int j = 0; j < n; j++){
                dp[i][j] = grid[i][j] + (dp[i - 1][j] == mn ? mn2 : mn);
                if(dp[i][j] < tmn){
                    tmn2 = tmn;
                    tmn = dp[i][j];
                }else if(dp[i][j] < tmn2){
                    tmn2 = dp[i][j];
                }
            }
            mn = tmn;
            mn2 = tmn2;
        }

        return mn;
    }
}
