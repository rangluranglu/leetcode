package question;

public class q200 {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1'){
                    ans ++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }


    public void dfs(char[][] grid, int i, int j){
        grid[i][j] = '0';

        for(int d = 0; d < 4; d++){
            int x = i + directions[d][0];
            int y = j + directions[d][1];
            if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1'){
                dfs(grid,x,y);
            }
        }

    }
}
