package WeekCompetition.year2022.W312;

import java.util.*;
import java.util.stream.IntStream;

public class q6191 {
    public static void main(String[] args) {
        int[] vals = {1,3,2,1,3};
        int[][] edges = {{0,1}, {0,2},{2,3},{2,4}};
        System.out.println(numberOfGoodPaths(vals, edges));

    }

    public static int numberOfGoodPaths(int[] vals, int[][] edges) {
        // 超时
        int n = vals.length;
        int[][] edge = new int[n][n];
        int[][] path = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(edge[i], Integer.MAX_VALUE >> 1);
            Arrays.fill(path[i], -2);
            edge[i][i] = 0;
            path[i][i] = -1;
        }


        for(int[] e : edges){
            edge[e[0]][e[1]] = 1;
            edge[e[1]][e[0]] = 1;
            path[e[0]][e[1]] = -1;
            path[e[1]][e[0]] = -1;
        }

        // 相等的值
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(vals[i], a -> new ArrayList<>());
            map.get(vals[i]).add(i);
        }

        // 最短路径
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(edge[i][k] + edge[k][j] < edge[i][j]){
                        edge[i][j] = edge[i][k] + edge[k][j];
                        path[i][j] = k;
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(path));
        int ans = n;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(vals[i] == vals[j] && judgePath(path, i, j, vals[i], vals)){
                    ans ++;
                }
            }
        }

        return ans;
    }


    public static boolean judgePath(int[][] path, int i, int j, int a, int[] vals){
        if(path[i][j] == -1){
            return vals[i] <= a && vals[j] <= a;
        }
        if(path[i][j] == -2){
            return false;
        }else {
            int k = path[i][j];
            return vals[k] <= a && judgePath(path, i, k, a, vals) && judgePath(path, k, j, a, vals);
        }
    }

    int[] fa;
    public int numberOfGoodPaths2(int[] vals, int[][] edges) {
        // 并查集
        int n = vals.length;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x); // 建图
        }
        fa = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
        // size[x] 表示节点值等于 vals[x] 的节点个数，如果按照节点值从小到大合并，size[x] 也是连通块内的等于最大节点值的节点个数
        int[] size = new int[n];
        Arrays.fill(size, 1);

        Integer[] id = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        Arrays.sort(id, (i, j) -> vals[i] - vals[j]);

        int ans = n;
        for(int x : id){
            int vx = vals[x], fx = find(x);
            for(int y : g[x]){
                y = find(y);
                if(y == fx || vals[y] > vx){
                    continue;
                }
                if(vals[y] == vx){
                    ans += size[x] * size[y];
                    size[fx] += size[y];
                }
                fa[y] = fx;
            }
        }

        return ans;
    }

    int find(int x){
        if (fa[x] != x) fa[x] = find(fa[x]);
        return fa[x];
    }

}
