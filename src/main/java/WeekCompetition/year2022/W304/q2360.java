package WeekCompetition.year2022.W304;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class q2360 {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        // 记录入度
        int[] indeg = new int[n];

        for(int edge : edges){
            if(edge == -1){
                continue;
            }
            indeg[edge] ++;
        }

        // 拓扑排序
        int node = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(indeg[i] == 0){
                queue.offer(i);
                node ++;
            }
        }

        while(!queue.isEmpty()){
            int u = queue.poll();
            int v = edges[u];
            if(v == -1){
                continue;
            }
            if(--indeg[v] == 0){
                queue.offer(v);
                node ++;
            }
        }

        if(node == n){
            return -1;
        }

        // 有环找到酒醉长边
        int ans = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if(indeg[i] == 0 || visited.contains(i)){
                continue;
            }
            int len = bfs(i, edges, visited);
            ans = Math.max(len, ans);
        }

        return ans;

    }

    public int bfs(int i, int[] edges, Set<Integer> visited){
        int step = 0;
        while (true){
            if(visited.contains(i)){
                return step;
            }
            visited.add(i);
            i = edges[i];
            step++;
        }

    }
}
