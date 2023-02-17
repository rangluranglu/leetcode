package Year2023.Daily.M2.D17;

public class q1139 {
    public int largest1BorderedSquare(int[][] grid) {
        // 预处理
        // 动态规划
        // 记录左边和上边的连续1

        int m = grid.length, n = grid[0].length;

        int[][] left = new int[m + 1][n + 1];
        int[][] up = new int[m + 1][n + 1];
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(grid[i - 1][j - 1] == 1){
                    left[i][j] = left[i][j - 1] + 1;
                    up[i][j] = up[i - 1][j] + 1;

                    int length = Math.min(left[i][j], up[i][j]);
                    while (left[i - length + 1][j] < length || up[i][j - length + 1] < length){
                        length --;
                    }

                    ans = Math.max(ans, length);
                }
            }
        }

        return ans * ans;
    }
}
