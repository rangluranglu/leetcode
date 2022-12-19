package Daily.year2022.M12.D19;

import java.util.*;

public class q1971 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // 边

        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, a -> new ArrayList<>());
        for (int[] edge : edges){
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        boolean[] visited = new boolean[n];
        visited[source] = true;


        while (!queue.isEmpty()){
            int node = queue.poll();
            if(node == destination){
                break;
            }
            for (int edge : g[node]) {
                if(!visited[edge]){
                    queue.offer(edge);
                    visited[edge] = true;
                }
            }
        }

        return visited[destination];

    }
}
