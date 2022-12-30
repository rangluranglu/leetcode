package Year2022.Week.W320;

import java.util.ArrayList;
import java.util.List;

public class q2477 {
    List<List<Integer>> edges;
    int ans = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
        // 拓扑排序
        // 记录当前节点人数 [每条路径的长度 / seats] 和

        edges = new ArrayList<>();
        int n = roads.length + 1;
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }

        for(int[] road : roads){
            edges.get(road[0]).add(road[1]);
            edges.get(road[1]).add(road[0]);
        }

        dfs(0, -1,seats);

        return ans;
    }

    private int dfs(int cur, int fa,int seats) {

        int size = 1;
        // dfs
        for(int to : edges.get(cur)){
            if(to != fa){
                size += dfs(to, cur, seats);
            }
        }

        if(cur > 0){
            // 向上
            ans += (size + seats - 1) / seats;
        }

        // 子节点数目
        return size;
    }
}
