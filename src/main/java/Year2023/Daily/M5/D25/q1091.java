package Year2023.Daily.M5.D25;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class q1091 {

    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1,1}, {1, -1}, {1, 1}};
    int ans, n;
    public int shortestPathBinaryMatrix(int[][] grid) {
        // bfs
        n = grid.length;

        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1){
            return -1;
        }

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;
        ans = 1;

        while (!queue.isEmpty()){
            int size = queue.size();
            while (size -- > 0){
                int[] arr = queue.poll();
                int x = arr[0], y = arr[1];

                if(x == n - 1 && y == n - 1){
                    return ans;
                }

                for (int i = 0; i < 8; i++) {
                    int newx = x + directions[i][0];
                    int newy = y + directions[i][1];

                    if(newx >= 0 && newx < n && newy >= 0 && newy < n && grid[newx][newy] == 0){
                        grid[newx][newy] = 1;
                        queue.offer(new int[]{newx, newy});
                    }
                }
            }

            ans ++;
        }
        return -1;
    }
}
