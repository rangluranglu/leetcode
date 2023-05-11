package Year2023.Daily.M5.D8;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class q1263 {
    public int minPushBox(char[][] grid) {
        // 边界状态处理
        // 人和箱子移动的状态处理

        // 0-1 广度优先搜索

        int m = grid.length, n = grid[0].length;

        int sx = -1, sy = -1, bx = -1, by = -1;  // 玩家和箱子的初始位置

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 'S'){
                    sx = i;
                    sy = j;
                }else if(grid[i][j] == 'B'){
                    bx = i;
                    by = j;
                }
            }
        }

        int[] d = {0, -1, 0, 1, 0};
        int[][] dp = new int[m * n][m * n];

        for (int i = 0; i < m * n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }


        Queue<int[]> queue = new ArrayDeque<>();
        dp[sx * n + sy][bx * n + by] = 0;   // 初始状态推动次数为0

        queue.offer(new int[]{sx * n + sy,bx * n + by});

        while (!queue.isEmpty()){
            Queue<int[]> queue1 = new ArrayDeque<>();

            while(!queue.isEmpty()){
                int[] arr = queue.poll();
                int s1 = arr[0], b1 = arr[1];

                int sx1 = s1 / n, sy1 = s1 % n, bx1 = b1 / n, by1 = b1 % n;

                if(grid[bx1][by1] == 'T'){
                    return dp[s1][b1];
                }


                // 玩家移动
                for (int i = 0; i < 4; i++) {
                    int sx2 = sx1 + d[i], sy2 = sy1 + d[i + 1], s2 = sx2 * n + sy2;

                    if(!ok(grid, m, n, sx2, sy2)){
                        // 玩家位置不合法
                        continue;
                    }

                    if(bx1 == sx2 && by1 == sy2){
                        // 推动箱子
                        int bx2 = bx1 + d[i], by2 = by1 + d[i + 1], b2 = bx2 * n + by2;
                        if(!ok(grid, m, n, bx2, by2) || dp[s2][b2] <= dp[s1][b1] + 1){
                            continue;
                        }

                        dp[s2][b2] = dp[s1][b1] + 1;
                        queue1.offer(new int[]{s2, b2});
                    }else{
                        if(dp[s2][b1] <= dp[s1][b1]){
                            continue;
                        }
                        dp[s2][b1] = dp[s1][b1];
                        queue.offer(new int[]{s2, b1});
                    }
                }


            }
            queue = queue1;
        }
        return -1;
    }

    public boolean ok(char[][] grid, int m, int n, int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != '#';
    }
}
