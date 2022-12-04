package WeekCompetition.year2022.atemplate;

import Common.ListNode;

import java.util.*;

public class question3 {

    public int minScore4(int n, int[][] roads) {
        // 最短路径
        int ans = Integer.MAX_VALUE;
        for (int[] road : roads){
            ans = Math.min(road[2], ans);
        }
        return ans;

    }
    int n;
    int ans = Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {
        // 最短路径
        this.n = n;
        Map<Integer, List<int[]>> edges = new HashMap<>();

        for(int[] road : roads){
            edges.computeIfAbsent(road[0], a -> new ArrayList<>());
            edges.computeIfAbsent(road[1], a -> new ArrayList<>());

            edges.get(road[0]).add(new int[]{road[1], road[2]});
            edges.get(road[1]).add(new int[]{road[0], road[2]});
        }

        dfs(1, edges, 0, Integer.MAX_VALUE);
        return ans;

    }

    private void dfs(int cur, Map<Integer, List<int[]>> edges, int pre, int path) {

        if(cur == n){
            ans = Math.min(ans, path);
        }

        for(int[] edge : edges.get(cur)){
            if(edge[0] != pre){
                dfs(edge[0], edges, cur, Math.min(path, edge[1]));
            }
        }
    }

    public int minScore3(int n, int[][] roads) {
        // 最短路径
        int MAX = Integer.MAX_VALUE / 2;
        boolean[] s = new boolean[n + 1];
        int[][] graph = new int[n +  1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], MAX);
        }

        for(int[] road : roads){
            graph[road[0]][road[1]] = road[2];
            graph[road[1]][road[0]] = road[2];
        }

        for (int i = 0; i < graph.length; i++) {//  floyd。
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph.length; k++) {
                    if (Math.min(graph[j][i], graph[i][k]) < graph[j][k]) {
                        graph[j][k] = Math.min(graph[j][i], graph[i][k]);
                    }
                }
            }
        }
        return graph[1][n];
    }
    public int minScore2(int n, int[][] roads) {
        // 最短路径
        int MAX = Integer.MAX_VALUE / 2;
        boolean[] s = new boolean[n + 1];
        int[][] graph = new int[n +  1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], MAX);
        }

        for(int[] road : roads){
            graph[road[0]][road[1]] = road[2];
            graph[road[1]][road[0]] = road[2];
        }

        s[1] = true;

        int[] dis = new int[n +1];
        for (int i = 1; i < n + 1; i++) {
            dis[i] = graph[1][i];
        }
        System.out.println(Arrays.toString(dis));

        for (int i = 1; i <= n; i++) {
            int tmpdis = MAX;
            int tmpindex = 0;

            for(int j = 1; j <= n; j++){
                if(!s[j] && dis[j] < tmpdis){
                    tmpdis = dis[j];
                    tmpindex = j;
                }
            }

            s[tmpindex] = true;
            for(int j = 1; j <= n; j++){
                if(dis[j] > Math.min(dis[tmpindex] ,graph[tmpindex][j])){
                    dis[j] = Math.min(dis[tmpindex], graph[tmpindex][j]);
                }
            }

        }
        System.out.println(Arrays.toString(dis));
        return dis[n];
    }

}
