package Year2023.Daily.M6.D12;

import java.util.Arrays;

public class q1483 {
}


class TreeAncestor {

    // k <= n <= 5 * 10^4
    static final int LOG = 16;
    int[][] ancestors;

    public TreeAncestor(int n, int[] parent) {
        // 倍增，预处理出节点的祖先节点
        ancestors = new int[n][16];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ancestors[i], -1);
        }

        for (int i = 0; i < n; i++) {
            ancestors[i][0] = parent[i];
        }

        for(int j = 1; j < LOG; j++){
            for (int i = 0; i < n; i++) {
                if(ancestors[i][j - 1] != -1){
                    ancestors[i][j] = ancestors[ancestors[i][j - 1]][j - 1];
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        // 返回节点的第k个祖先节点
        for(int j = 0; j < LOG; j++){
            if(((k >> j) & 1) != 0){
                node = ancestors[node][j];

                if(node == -1){
                    return -1;
                }
            }
        }

        return node;
    }
}