package Year2023.Week.W340;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.TreeSet;

public class q2617 {
    public int minimumVisitedCells(int[][] grid) {
        // 网格图中最少访问的格子数

        // (0, 0) -->  (i, j)
        // j < k <= grid[i][j] + j 的格子(i, k)
        // i < k <= grid[i][j] + i 的格子 (k, j)
        // 最少移动格子数 向右或向下
        // 有重叠子问题 --> DP

        // dp[i][j] 表示从 (i, j) 出发， 到右下角最少移动格子数
        // dp[i][j] = min{min(k=j+1, j+g) f[j][k], min(k=i+1, i+g) f[k][i]} + 1
        // 复杂度 O(mn(m + n))
        // 线段树优化

        // bfs + 平衡树 维护没有访问过的节点
        // 平衡树维护访问过的节点

        int m = grid.length, n = grid[0].length;
        // m 个 平衡树
        TreeSet<Integer>[] row_set = new TreeSet[m];
        TreeSet<Integer>[] col_set = new TreeSet[n];

        Arrays.setAll(row_set, e->new TreeSet<>());
        Arrays.setAll(col_set, e->new TreeSet<>());
        // 初始化 , 有哨兵节点
        for(TreeSet<Integer> a : row_set){
            for(int j = 0; j <= n; j++){
                a.add(j);
            }
        }

        for(TreeSet<Integer> b : col_set){
            for(int i = 0; i <= m; i++){
                b.add(i);
            }
        }

        // bfs
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0 ,0});
        int ans = 0;

        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] poll = queue.poll();
                if(poll[0] == m - 1 && poll[1] == n - 1){
                    return ans;
                }

                int g = grid[poll[0]][poll[1]];
                // 向右
                TreeSet<Integer> row = row_set[poll[0]];
                int right = Math.min(n, g + poll[1] + 1);
                for(int v = row.ceiling(poll[1] + 1); v < right; v=row.ceiling(poll[1] + 1)){
                    if(poll[0] == m - 1 && v == n - 1){
                        return ans + 1;
                    }
                    queue.add(new int[]{poll[0], v});
                    row.remove(v);
                }
                // 向下
                TreeSet<Integer> col = col_set[poll[1]];
                int down = Math.min(n , g + poll[0] + 1);
                for(int v = col.ceiling(poll[0] + 1); v < down; v = row.ceiling(poll[0] + 1)){
                    if(v == m - 1 && poll[1] == n - 1){
                        return ans + 1;
                    }
                    queue.add(new int[]{v, poll[1]});
                    col.remove(v);
                }
            }
            ans++;
        }

        return -1;

    }
}
