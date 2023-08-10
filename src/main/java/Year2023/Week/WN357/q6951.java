package Year2023.Week.WN357;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class q6951 {
    int[][] dist;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int[][] vis;
    ConcurrentHashMap
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        // 最大安全系数
        // 最小距离最大

        // bfs求安全系数

        int m = grid.size(), n = grid.get(0).size();
        if(grid.get(m - 1).get(n - 1) == 1 || grid.get(0).get(0) == 1){
            return 0;
        }
        dist = new int[m][n];
        vis = new int[m][n];
        Deque<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid.get(i).get(j) == 1){
                    queue.add(new int[]{i, j});
                    dist[i][j] = 0;
                }else {
                    dist[i][j] = -1;
                }
            }
        }

        while(!queue.isEmpty()){
            int[] node = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = dirs[i][0] + node[0];
                int ny = dirs[i][1] + node[1];

                if(nx >= 0 && nx < m && ny >= 0 && ny < n && dist[nx][ny] == -1){
                    queue.offer(new int[]{nx, ny});
                    dist[nx][ny] = dist[node[0]][node[1]] + 1;
                }

            }
        }

        // 二分答案
        int l = 0, r = 2 * m;
        while (l <= r){
            int mid = l + (r - l) / 2;

            vis[0][0] = 1;

            boolean res = dist[0][0] >= mid && dfs(0, 0, mid);

            if(res){
                l
            }

        }
    }
}
