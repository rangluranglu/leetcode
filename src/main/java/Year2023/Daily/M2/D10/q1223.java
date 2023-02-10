package Year2023.Daily.M2.D10;

public class q1223 {
    static final int mod = (int) 1e9 + 7;
    public int dieSimulator(int n, int[] rollMax) {
        // n次

        // dp[i] 第i次， 怎么规划
        // dp[i][j][k] 完成i次， 第i次是j， 并且连续k次j的合法序列

        int[][][] dp = new int[n + 1][6][16];

        // 初始化
        for (int i = 0; i < 6; i++) {
            dp[1][i][1] = 1;
        }

        for(int i = 2; i <= n; i++){
            // 枚举上一层
            for(int j = 0; j < 6; j++){
                for(int k = 1; k <= rollMax[i]; k++){
                    // 本次
                    for(int p = 0; p < 6; p++){
                        if(p != j){
                            dp[i][p][1] = (dp[i][p][1] + dp[i - 1][j][k]) % mod;
                        }else if(k + 1 <= rollMax[i]){
                            dp[i][p][k + 1] = (dp[i][p][k + 1] + dp[i - 1][p][k]) % mod;
                        }
                    }
                }
            }
        }

        int ans = 0;

        for(int j = 0; j < 6; j++){
            for(int k = 1; k <= rollMax[j]; k++){
                ans = (ans + dp[n][j][k]) % mod;
            }
        }

        return ans;
    }

    public int dieSimulator2(int n, int[] rollMax) {
        // n次
        // dp[i][j] 完成了i次，第i次是j时是合法序列

        int[][] dp = new int[n + 1][6];
        int[] sum = new int[n + 1];

        sum[0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < 6; j++){
                int pos = Math.max(i - rollMax[j] -1, 0);
                int sub = ((sum[pos] - dp[pos][j]) % mod + mod) % mod;
                dp[i][j] = ((sum[i - 1] - sub) % mod + mod) % mod;

                if(i <= rollMax[j]){
                    dp[i][j] = (dp[i][j] + 1) % mod;
                }

                sum[i] = (sum[i] + dp[i][j]) % mod;
            }
        }

        return sum[n];
    }
}
