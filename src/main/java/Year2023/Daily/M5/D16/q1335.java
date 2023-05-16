package Year2023.Daily.M5.D16;

import java.util.Arrays;

public class q1335 {
    public int minDifficulty(int[] jobDifficulty, int d) {
        // d天工作计划，总难度 和， 返回最小的难度

        if(jobDifficulty.length < d){
            return -1;
        }

        int n = jobDifficulty.length;
        // 前i+1天完成j项工作的最小难度;
        int[][] dp = new int[d + 1][n];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        int ma = 0;
        for (int i = 0; i < n; i++) {
            ma = Math.max(ma, jobDifficulty[i]);
            dp[0][i] = ma;
        }

        for (int i = 1; i < d; i++) {
            for(int j = i; j < n; j++){
                ma = 0;
                for(int k = j; k >= i; k--){
                    ma = Math.max(ma, jobDifficulty[k]);
                    dp[i][j] = Math.min(dp[i][j], ma + dp[i - 1][k - 1]);
                }
            }
        }
        return dp[d - 1][n - 1];

    }
}
