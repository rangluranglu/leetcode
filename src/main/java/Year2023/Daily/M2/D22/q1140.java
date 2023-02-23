package Year2023.Daily.M2.D22;

public class q1140 {
    public int stoneGameII(int[] piles) {
        // 手中石子最多
        // 爱丽丝 先手
        // 动态规划 --> 需要存储状态。
        // dp[i][j] 表示剩余， [i : len - 1] 堆时，M=j的情况下，先取的人能获得的最多石子数
        // 1. i + 2M >= len, dp[i][M] = sum[i : len - 1];
        // 2. i + 2M < len, dp[i][M] = max(dp[i][M], dp[i + x][max(M,x)],  其中 i <= x <= 2M

        int len = piles.length, sum = 0;
        int[][] dp = new int[len][len + 1];

        for (int i = len - 1; i >= 0; i--) {
            sum += piles[i];

            for(int M = 1; M <= len; M++){
                if(i + 2 * M >= len){
                    dp[i][M] = sum;
                }else {
                    for(int x = 1; x <= 2 * M; x++){
                        dp[i][M] = Math.max(dp[i][M], sum - dp[i + x][Math.max(M, x)]);
                    }
                }
            }
        }

        return dp[0][1];

    }
}
