package question;

import java.util.Arrays;

public class q1049 {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;

        int sum = Arrays.stream(stones).sum();

        int m = sum / 2;

        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for(int i = 0; i < n; i++){
            for(int j = 0; j <= m; j++){
                if(j < stones[i]){
                    dp[i + 1][j] = dp[i][j];
                }else{
                    dp[i + 1][j] = dp[i][j] || dp[i][j - stones[i]];
                }
            }
        }

        for(int j = m; ; j--){
            if(dp[n][j]){
                return sum - 2 * j;
            }
        }

    }

    public int lastStoneWeightII2(int[] stones) {
        // dp优化，使用一维数组

        int n = stones.length;

        int sum = Arrays.stream(stones).sum();

        int m = sum / 2;

        boolean[] dp = new boolean[m + 1];
        dp[0] =  true;

        for (int i = 0; i < n; i++) {
            for (int j = m; j >= stones[i]; j++) {
                dp[j] = dp[j] || dp[j - stones[i]];
            }
        }

        for(int j = m; ; j--){
             if(dp[j]){
                 return sum - 2 * j;
             }
        }

    }
}
