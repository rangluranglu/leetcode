package Year2022.Week.W322;

import java.util.*;

public class q2492 {
    public int minScore(int n, int[][] roads) {
        // 找联通块中的最小值， 联通块
        // bfs;
        Map<Integer, List<int[]>> edges = new HashMap<>();

        for(int[] road : roads){
            edges.computeIfAbsent(road[0], a -> new ArrayList<>());
            edges.computeIfAbsent(road[1], a -> new ArrayList<>());

            edges.get(road[0]).add(new int[]{road[1], road[2]});
            edges.get(road[1]).add(new int[]{road[0], road[2]});
        }

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        visited[1] = true;
        int ans = Integer.MAX_VALUE;
        while (!q.isEmpty()){
            int node = q.poll();

            for(int[] edge : edges.get(node)){
                ans = Math.min(ans, edge[1]);
                if(!visited[edge[0]]){
                    q.add(edge[0]);
                    visited[edge[0]] = true;

                }
            }
        }

        return ans;


    }
}
