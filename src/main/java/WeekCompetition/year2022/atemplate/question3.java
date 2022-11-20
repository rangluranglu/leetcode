package WeekCompetition.year2022.atemplate;

import java.util.*;

public class question3 {
    public long minimumFuelCost(int[][] roads, int seats) {
        // bfs
        int n = roads.length + 1;
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for(int[] road : roads){
            edges.get(road[0]).add(road[1]);
            edges.get(road[1]).add(road[0]);
        }
        boolean[] visited = new boolean[n];
        // 只有初始有岔路
        // 初始化
        Queue<Integer> queue = new ArrayDeque<>();

        List<Integer> road = new ArrayList<>();
        for(int i : edges.get(0)){
            queue.offer(i);
            visited[i] = true;
            road.add(1);
        }
        visited[0] = true;
        int baseSize = queue.size();

        int ans = baseSize;
        while (!queue.isEmpty()){
            // 分层
            int size = queue.size();
            Set<Integer> remove = new HashSet<>();
            for (int i = 0; i < size; i++) {
                road.set(i, road.get(i) + 1);
                if(road.get(i) % seats == 1){
                    ans += (road.get(i) / seats) * seats;

                }
                ans += 1;
                int node = queue.poll();
                for(int edge : edges.get(node)){
                    if(!visited[edge]){
                        queue.offer(edge);
                        visited[edge] =true;
                    }
                }
                if (queue.size() < size){
                    remove.add(i);
                }
            }

            for (Integer integer : remove) {
                road.remove(integer);
            }
        }

        return ans;

    }
}
