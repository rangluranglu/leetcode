package Year2022.Daily.M10.D25;

import java.util.ArrayDeque;
import java.util.Queue;

public class q934 {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int n;
    public int shortestBridge(int[][] grid) {
        // 先深度，再广度优先搜索
        n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    // 深度优先搜索
                    Queue<int[]> queue = new ArrayDeque<>();
                    dfs(i, j, grid, queue);

                    int step = 0;
                    while (!queue.isEmpty()){
                        // bfs
                        int size = queue.size();
                        for(int k = 0; k < size; k++){
                            int[] cell = queue.poll();
                            int x = cell[0], y = cell[1];
                            for(int l = 0; l < 4; l++){
                                int ni = x + dirs[l][0];
                                int nj = y + dirs[l][1];

                                if(ni >= 0 && ni < n && nj >= 0 && nj < n ){
                                    if(grid[ni][nj] == 0){
                                        queue.offer(new int[]{ni, nj});
                                        grid[ni][nj] = -1;
                                    }else if(grid[ni][nj] == 1){
                                        return step;
                                    }
                                }
                            }
                        }
                        step ++;
                    }
                }
            }
        }

        return 0;
    }

    private void dfs(int i, int j, int[][] grid, Queue<int[]> queue) {

        // dfs

        if(grid[i][j] != 1){
            return;
        }

        queue.offer(new int[]{i, j});
        grid[i][j] = -1;

        for(int k = 0; k < 4; k++){
            int ni = i + dirs[k][0];
            int nj = j + dirs[k][1];

            if(ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] == 1){
                dfs(ni, nj, grid, queue);
            }
        }

    }
}
