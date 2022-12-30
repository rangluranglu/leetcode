package Year2022.Daily.M9.D18;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class q827 {
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int largestIsland(int[][] grid) {
        // dfs 标记
        int m = grid.length, n = grid[0].length;
        int res = 0;
        int[][] tag = new int[m][n];
        Map<Integer, Integer> area = new HashMap<>();
        int t  = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && tag[i][j] == 0){
                    area.put(t, dfs(grid, i, j, tag, t));
                    res = Math.max(res, area.get(t));
                    t++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int z = 1;
                    Set<Integer> connected = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int x = i + directions[k][0];
                        int y = j + directions[k][1];
                        if (!valid(n, x, y) || tag[x][y] == 0 || connected.contains(tag[x][y])){
                            continue;
                        }
                        z += area.get(tag[x][y]);
                        connected.add(tag[x][y]);
                    }
                    res = Math.max(res, z);
                }
            }

        }

        return res;

    }

    public int dfs(int[][] grid, int x, int y, int[][] tag, int t){
        int n = grid.length, res = 1;
        tag[x][y] = t;

        for (int i = 0; i < 4; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if(valid(n, newX, newY) && grid[newX][newY] == 1 && tag[newX][newY] == 0){
                res += dfs(grid, newX, newY, tag, t);
            }
        }
        return res;
    }

    private boolean valid(int n, int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
