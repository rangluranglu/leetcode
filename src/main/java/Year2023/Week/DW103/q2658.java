package Year2023.Week.DW103;

public class q2658 {

    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;
    public int findMaxFish(int[][] grid) {
        // 从水域出发 grid[i][j] > 0  --> 捕捞所有鱼 或 移动到相邻格子
        // 最多可以捕捞掉多少鱼

        // 标准dfs

        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] > 0){
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
        }

        return ans;

    }

    private int dfs(int[][] grid, int i, int j){
        if(grid[i][j] == 0){
            return 0;
        }

        int s = grid[i][j];
        grid[i][j] = 0;
        for (int k = 0; k < 4; k++) {
            int newi = i + directions[k][0];
            int newj = j + directions[k][1];


            if(newi >= 0 && newi < m && newj >= 0 && newj < n && grid[newi][newj] > 0){
                s += dfs(grid, newi, newj);
            }
        }

        return s;
    }
}
