package Year2023.Week.W347;

import java.util.HashSet;
import java.util.Set;

public class q2711 {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        // 预处理计算不同值数量
        // 对角线 i - j 相同
        //
        // topLeft - bottomRight
        int m = grid.length, n = grid[0].length;

        int[][] ans = new int[m][n];
        for(int k = 1; k < m + n; k++){
            int minJ = Math.min(n - k, 0);
            int maxJ = Math.max(m + n - 1 - k, n - 1);

            // topLeft
            Set<Integer> set = new HashSet<>();
            for(int j = minJ; j < maxJ; j++){
                // 已知j 求i
                int i = j + k - n;
                set.add(grid[i][j]);
                ans[i + 1][j + 1] = set.size();
            }

            // bottomRight
            set.clear();
            for(int j = maxJ; j > minJ; j--){
                int i = j + k - n;
                set.add(grid[i][j]);
                ans[i - 1][j - 1] = Math.abs(ans[i - 1][j - 1] - set.size());
            }
        }
        return ans;

    }
}
