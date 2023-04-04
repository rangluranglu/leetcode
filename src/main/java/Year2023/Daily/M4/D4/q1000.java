package Year2023.Daily.M4.D4;

import java.util.Arrays;

public class q1000 {

    static final int INF = 0x3f3f3f3f;
    int[][][] d;
    int[] sum;
    int k;
    public int mergeStones(int[] stones, int k) {
        // 将连续的k堆合并为一堆
        // 每次都选最小的合并

        // 动态规划
        // dp[l][r][t] 表示将 [l, r] 合并为t堆的最低成本
        // dp[i][i][1] 初始化为0,
        // 转移 t == 1 时, dp[l][r][t] = dp[l][r][k] + sum[l][r]
        // dp[l][r][t] = min{dp[l][p][1] + dp[p+1][r][t-1]}  l <= p < r
        // 目标 dp[0][n - 1][1]

        int n = stones.length;
        if((n - 1) %(k - 1) != 0){
            return -1;
        }

        this.k = k;
        d = new int[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(d[i][j], -1);
            }
        }

        sum = new int[n];

        // 初始化
        for (int i = 0, s = 0; i < n; i++) {
            d[i][i][1] = 0;
            s += stones[i];

            sum[i] = s;
        }

        int res = get(0, n - 1, 1);

        return res;
    }

    public int get(int l, int r, int t){
        // 若d[l][r][t] 不为-1， 证明已经求解过

        if(d[l][r][t] != -1){
            return d[l][r][t];
        }

        if(t > r - l + 1){
            return INF;
        }

        if(t == 1){
            int res = get(l, r, k);
            if(res == INF){
                return d[l][r][t] = INF;
            }

            return d[l][r][t] = res + (sum[r] - (l == 0 ? 0 : sum[l - 1]));
        }

        int val = INF;
        for(int p = l; p < r; p += (k - 1)){
            val = Math.min(val, get(l, p, 1) + get(p + 1, r, t - 1));
        }

        return d[l][r][t] = val;
    }
}
