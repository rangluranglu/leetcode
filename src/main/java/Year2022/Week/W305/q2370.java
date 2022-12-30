package Year2022.Week.W305;

import java.util.*;

public class q2370 {
    int ans;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        // dfs;
        ans = 0;
        boolean[] visited = new boolean[n];
        // 构造邻接表
        Map<Integer, List<Integer>> map = new HashMap();
        for(int[] edge : edges){
            map.computeIfAbsent(edge[0], a ->new ArrayList<Integer>());
            List<Integer> list = map.get(edge[0]);
            list.add(edge[1]);
            map.computeIfAbsent(edge[1], a ->new ArrayList<Integer>());
            List<Integer> list1 = map.get(edge[1]);
            list1.add(edge[0]);
        }


        Set<Integer> set = new HashSet<>();
        for(int res : restricted){
            set.add(res);
        }


        dfs(map, 0, set, visited);

        return ans;
    }

    public void dfs(Map<Integer, List<Integer>> edges, int i, Set<Integer> restricted, boolean[] visited){
        if(visited[i] || restricted.contains(i)){
            return;
        }

        visited[i] = true;
        ans ++;

        for(int edge : edges.get(i)){
            dfs(edges, edge, restricted, visited);
        }
    }
}
