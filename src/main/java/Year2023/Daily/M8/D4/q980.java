package Year2023.Daily.M8.D4;

import java.util.HashMap;
import java.util.Map;

public class q980 {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int uniquePathsIII(int[][] grid) {
        // 回溯
        int r = grid.length, c = grid[0].length;
        int si = 0, sj = 0, n = 0;


        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 0){
                    n ++;
                }else if(grid[i][j] == 1){
                    n ++;
                    si = i;
                    sj = j;
                }
            }
        }

        return dfs(grid, si, sj, n);
    }

    private int dfs(int[][] grid, int i, int j, int n){
        if(grid[i][j] == 2){
            return n == 0 ? 1 : 0;
        }

        int r = grid.length, c = grid[0].length;
        int t = grid[i][j];
        grid[i][j] = -1;

        int res = 0;
        for(int[] dir : dirs){
            int ni = i + dir[0], nj = j + dir[1];
            if(ni >= 0 && ni < r && nj >= 0 && nj < c && (grid[ni][nj] == 0 || grid[ni][nj] == 2)){
                res += dfs(grid, ni, nj, n - 1);
            }
        }

        grid[i][j] = t;
        return res;
    }


    private Map<Integer, Integer> memo = new HashMap<>();
    public int uniquePathsIII2(int[][] grid) {
        // 回溯
        int n = grid[0].length;
        int vis = 0, sx = -1, sy = -1;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    vis |= 1 << (i * n + j);
                }else if(grid[i][j] == 1){
                    sx = i;
                    sy = j;
                }
            }
        }

        return dfs2(grid, sx, sy, vis);
    }

    private int dfs2(int[][] grid, int x, int y, int vis){
        int m = grid.length, n = grid[0].length;

        int p = x * n + y;
        if(x < 0 || x >= m || y < 0 || y >= n || (vis >> p & 1) > 0){
            return 0;
        }

        // 标记访问过的
        vis |= 1 << p;
        if(grid[x][y] == 2){
            // 到达终点
            return vis == (1 << m * n) - 1 ? 1 : 0;
        }

        int key = (p << m * n) | vis;  // 参数压缩成一个整数
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        int ans = dfs(grid, x - 1, y, vis) + dfs(grid, x, y - 1, vis) +
                dfs(grid, x + 1, y, vis) + dfs(grid, x, y + 1, vis);

        memo.put(key, ans);

        return ans;

    }
}
