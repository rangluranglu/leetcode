package Template;

import java.util.Arrays;

public class Floyd {

    // 定义d[k][i][j] 表示从i到j的最短路径长度， 并且从i到j的路径上的中间节点（不含i和j）的编号至多为k
    public int simpleFloyd(int[][] edges, int start, int end){
        int n = edges.length;

        // g用来保存点到点的最短距离
        int[][] d = new int[n][n];
        int INF = Integer.MAX_VALUE / 2;
        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], INF);
            d[i][i] = 0;
        }

        for(int[] e : edges){
            d[e[0]][e[1]] = e[2];  // 添加一条边， 保证输入没有重边和自环
        }

        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }

        return d[start][end] < INF ? d[start][end] : -1;
    }
}
