package Year2023.Week.DW102;

import java.util.Arrays;

public class q2639 {
    public int[] findColumnWidth(int[][] grid) {
        // 遍历

        int m = grid.length, n = grid[0].length;

        int[] ans = new int[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                ans[j] = Math.max(ans[j], (grid[i][j] + "").length());
            }
        }

        return ans;
    }
}
