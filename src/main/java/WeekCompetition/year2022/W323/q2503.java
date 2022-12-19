package WeekCompetition.year2022.W323;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class q2503 {
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[] maxPoints(int[][] grid, int[] queries) {
        // 离线询问 + 并查集

        int k = queries.length;

        Integer[] id = IntStream.range(0, k).boxed().toArray(Integer[]::new);
        Arrays.sort(id, (i, j) -> queries[i] - queries[j]);

        int[] ans = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);


        pq.add(new int[]{grid[0][0], 0, 0});
        grid[0][0] = 0;

        int m = grid.length, n = grid[0].length;
        int cnt = 0;

        for(int i : id){
            // 遍历id
            int q = queries[i];
            while (!pq.isEmpty() && pq.peek()[0] < q){
                cnt ++;
                int[] p = pq.poll();
                // 遍历周围4个格子
                for(int[] d : dirs){
                    int x = p[1] + d[0];
                    int y = p[2] + d[1];

                    if(0 <= x && x < m && 0 <= y && y < n && grid[x][y] > 0){
                        pq.add(new int[]{grid[x][y], x, y});
                        grid[x][y] = 0;
                    }
                }


            }

            ans[i] = cnt;
        }

        return ans;

    }


    public int[] maxPoints2(int[][] grid, int[] queries) {

        // 最短路径问题
        // todo

        return new int[1];
    }
}
