package WeekCompetition.year2022.W313;

public class q2428 {
    public int maxSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // 预处理
        int[][] sum = new int[m][n];
        for (int i = 0; i < m; i++) {
            sum[i][2] = grid[i][0] + grid[i][1] + grid[i][2];
            for (int j = 3; j < n; j++) {
                sum[i][j] = sum[i][j - 1] + grid[i][j] - grid[i][j - 3];
            }
        }
        // System.out.println(Arrays.deepToString(sum));
        int ans = 0;
        for (int i = 0; i < m - 2; i++) {
            for(int j = 2; j < n; j++){
                int tmp = sum[i][j] + sum[i + 2] [j] + grid[i + 1][j - 1];
                if(tmp > ans){
                    ans = tmp;
                }
            }
        }

        return ans;
    }
}
