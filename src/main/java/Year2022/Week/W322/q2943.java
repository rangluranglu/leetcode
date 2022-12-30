package Year2022.Week.W322;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q2943 {
    private List<Integer>[] g;
    private final List<Integer> nodes = new ArrayList<>();
    private int[] time, color; //  time 充当 vis 数组的作用（避免在 BFS 内部重复创建 vis 数组）
    private int clock;

    public int magnificentSets(int n, int[][] edges) {
        // 层数， 拓扑排序
        // 图中所用的环都是偶数个定点，
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());

        for(int[] edge : edges){
            int x = edge[0] - 1;
            int y = edge[1] - 1;

            g[x].add(y);
            g[y].add(x);
        }

        time = new int[n];
        color = new int[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if(color[i] != 0){
                continue;
            }

            nodes.clear();;
            if(!isBipartire(i, 1)){
                // 如果不是二分图， 有寄环
                return -1;
            }

            int maxDepth = 0;
            for(int x : nodes){
                maxDepth = Math.max(maxDepth, bfs(x));
            }

            ans += maxDepth;
        }

        return ans;
    }

    private boolean isBipartire(int x, int c){
        // 二分图判定
        nodes.add(x);
        color[x] = c;

        for(int y : g[x]){
            if(color[y] == c || color[y] == 0 && !isBipartire(y, -c)){
                return false;
            }
        }

        return true;
    }

    // 从start 出发的最大深度
    private int bfs(int start){
        int depth = 0;
        time[start] = ++clock;

        List<Integer> q = new ArrayList<>();
        q.add(start);

        while(!q.isEmpty()){
            List<Integer> tmp = q;
            q = new ArrayList<>();
            for(int x : tmp){
                for (int y : g[x]){
                    if(time[y] != clock){
                        time[y] = clock;
                        q.add(y);
                    }
                }
            }
            depth ++;

        }

        return depth;
    }
}
