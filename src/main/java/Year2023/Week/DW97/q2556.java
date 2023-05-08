package Year2023.Week.DW97;

import java.util.Arrays;

public class q2556 {

    private int m, n;
    private int[][] g;
    public boolean isPossibleToCutPath(int[][] grid) {
        // 找桥

        m = grid.length;
        n = grid[0].length;
        g = grid;
        System.out.println(Arrays.deepToString(g));
        return !dfs(0, 0) || !dfs(0, 0);
    }

    private boolean dfs(int x, int y){

        if (x == m - 1 && y == n - 1){
            return true;
        }

        g[x][y] = 0;

        // 找下轮廓  !! 厉害
        return x < m - 1 && g[x + 1][y] > 0 && dfs(x + 1, y) ||
                y < n - 1 && g[x][y + 1] > 0 && dfs(x, y + 1);
    }
}
