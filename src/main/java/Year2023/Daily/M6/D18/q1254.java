package Year2023.Daily.M6.D18;

public class q1254 {

    private int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int m, n;
    public int closedIsland(int[][] grid) {
        // 封闭岛屿的数目 --> 如何判断封闭？
        // dfs

        // 1. 边缘dfs， 0--1
        // 2. dfs， 找到陆地数量

        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if(grid[i][0] == 0){
                dfs(grid, i, 0);
            }
            if(grid[i][n - 1] == 0){
                dfs(grid, i, n - 1);
            }
        }


        for (int j = 0; j < n; j++) {
            if(grid[0][j] == 0){
                dfs(grid, 0, j);
            }

            if(grid[m - 1][j] == 0){
                dfs(grid, m - 1, j);
            }
        }

        int ans = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if(grid[i][j] == 0){
                    dfs(grid, i, j);
                    ans ++;
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] grid, int i, int j){
        grid[i][j] = 1;
        for(int[] dir: directions){
            int newX = i + dir[0], newY = j +dir[1];
            if(newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 0){
                dfs(grid, newX, newY);
            }
        }
    }
}
