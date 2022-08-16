package question;

import java.util.ArrayDeque;
import java.util.Deque;

public class q1293 {
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int shortestPath(int[][] grid, int k) {
        // 广度优先搜索

        int m = grid.length, n = grid[0].length;
        if(m == 1 && n == 1){
            return 0;
        }

        // m + n - 3 表示最多的障碍
        // 剪枝
        if(k >= m + n - 3){
            return m + n - 2;
        }
        boolean[][][] visited = new boolean[m][n][k + 1];
        Deque<int[]> queue = new ArrayDeque<>();
        // 初始化
        visited[0][0][k] = true;
        queue.offer(new int[]{0, 0, k});

        // 广度优先
        for(int step = 1; queue.size() > 0; step++){
            int size = queue.size();

            while(size -- > 0){
                int[] node = queue.poll();
                for(int i = 0; i < 4; i++){
                    int x = node[0] + directions[i][0];
                    int y = node[1] + directions[i][1];
                    int rest = node[2];

                    if(x >= 0 && x < m && y >= 0 && y < n){
                        // 判断是有为墙
                        // 不为墙
                        if(grid[x][y] == 0 && !visited[x][y][rest]){
                            if(x == m - 1 && y == n - 1){
                                return step;
                            }

                            queue.offer(new int[]{x, y, rest});
                            visited[x][y][rest] = true;
                        }else if(grid[x][y] == 1 && rest > 0 && !visited[x][y][rest]){
                            queue.offer(new int[]{x, y, rest - 1});
                            visited[x][y][rest - 1] = true;
                        }

                    }
                }

            }

        }
        return -1;
    }
}
