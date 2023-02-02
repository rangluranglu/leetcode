package Year2023.Daily.M2.D2;

import java.util.*;

public class q1129 {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // 广度优先搜索
        // 0 是红色 1 是蓝色
        List<Integer>[][] next = new ArrayList[2][n];
        for (int i = 0; i < 2; i++) {
            Arrays.setAll(next[i], e -> new ArrayList<>());
        }

        for(int[] edge : redEdges){
            next[0][edge[0]].add(edge[1]);
        }

        for (int[] edge : blueEdges) {
            next[1][edge[0]].add(edge[1]);
        }

        int[][] dist = new int[2][n]; // 最短长度
        for (int i = 0; i < 2; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        dist[0][0] = 0;
        dist[1][0] = 0;
        queue.offer(new int[]{0, 1});
        queue.offer(new int[]{0, 0});


        while (!queue.isEmpty()){
            int[] pair = queue.poll();
            int x = pair[0], t = pair[1];

            for(int y : next[1- t][x]){
                if(dist[1-t][y] != Integer.MAX_VALUE){
                    continue;
                }
                dist[1 - t][y] = dist[t][x] + 1;
                queue.offer(new int[]{y, 1 -t});
            }
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = Math.min(dist[0][i], dist[1][i]);
            if(answer[i] == Integer.MAX_VALUE){
                answer[i] = -1;
            }
        }

        return answer;
    }
}
