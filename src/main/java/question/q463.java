package question;

public class q463 {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1){
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int tx = i + dx[k];
                        int ty = j + dy[k];

                        if(tx < 0 || tx >= n || ty < 0 || ty >= m || grid[tx][ty] == 0){
                            cnt += 1;
                        }
                    }
                    ans += cnt;
                }

            }
        }
        return ans;
    }
}
