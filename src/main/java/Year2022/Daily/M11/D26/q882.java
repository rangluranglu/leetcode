package Year2022.Daily.M11.D26;


import java.util.*;

public class q882 {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        // 最短路径问题
        // 临接表
        List<int[]>[] adList = new List[n];

        for (int i = 0; i < n; i++) {
            adList[i] = new ArrayList<>();
        }

        // 初始化
        for(int[] edge : edges){
            int u = edge[0], v = edge[1], nodes = edge[2];
            adList[u].add(new int[]{v, nodes});
            adList[v].add(new int[]{u, nodes});
        }

        Map<Integer, Integer> used = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        int reachableNodes = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty() && pq.peek()[0] <= maxMoves){
            int[] pair = pq.poll();
            // 起点到该节点的路径
            int step = pair[0];
            int u = pair[1];

            if(!visited.add(u)){
                continue;
            }

            reachableNodes ++;
            for(int[] next : adList[u]){
                int v = next[0];
                int nodes = next[1];

                if(nodes + step + 1 <= maxMoves && !visited.contains(v)){
                    pq.offer(new int[]{nodes + step + 1, v});
                }
                used.put(encode(u, v, n), Math.min(nodes, maxMoves - step));
            }
        }

        // 统计
        for(int[] edge : edges){
            int u = edge[0], v = edge[1], nodes = edge[2];
            reachableNodes += Math.min(nodes, used.getOrDefault(encode(u,v,n), 0) + used.getOrDefault(encode(v,u,n), 0));

        }

        return reachableNodes;
    }

    private int encode(int u, int v, int n){
        return u * n + v;
    }
}
