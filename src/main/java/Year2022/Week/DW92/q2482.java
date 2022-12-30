package Year2022.Week.DW92;

public class q2482 {
    public int[][] onesMinusZeros(int[][] grid) {
        // 预处理
        // 可以优化的地方： 统计将 0 看成 -1；

        int m = grid.length, n = grid[0].length;

        int[] row = new int[m];
        int[] col = new int[n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i] += grid[i][j] * 2 -1;
                col[j] += grid[i][j] * 2 - 1;
            }
        }

        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = row[i] + col[j];
            }
        }
        return ans;

    }
}
