package question;

import java.util.ArrayDeque;
import java.util.Deque;

public class q994 {
    int[][] directions = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
    public int orangesRotting(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }

            }
        }

        int ans = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            ans ++;
            while (size -- > 0){
                int[] node = queue.poll();
                for (int i = 0; i < 4; i++){
                    int x = node[0] + directions[i][0];
                    int y = node[1] + directions[i][1];

                    if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1){
                        queue.offer(new int[]{x, y});
                        grid[x][y] = 2;
                    }
                }
            }

        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return ans == 0? ans : ans - 1;
    }
}
