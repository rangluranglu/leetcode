package Year2023.Week.W329;

import java.util.Arrays;

public class q2547 {
    public int minCost(int[] nums, int k) {
        // 代价是每个子数组中的重要性之和

        // 重要性 = k + trimmed(sub).length
        // 代价最小， 不一定是两个

        // dp[i] 表示nums 前i - 1个数的最小代价
        // dp[i + 1] = min(dp[j)  + i - j + 1 - unique(j,i) + k
        // = i + 1 + k + min(dp[j] - j - unique(j , 1))




        int n = nums.length;
        int[] dp = new int[n + 1];
        byte[] state = new byte[n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(state, (byte) 0);
            int unique = 0, mn = Integer.MAX_VALUE;

            for(int j = i; j >= 0; j--){
                int x = nums[j];
                if(state[x] == 0){
                    state[x] = 1;
                    unique ++;
                }else if(state[x] == 1){
                    state[x] = 2;
                    unique --;
                }

                mn = Math.min(mn, dp[j] - unique);
            }
            dp[i + 1] = k + mn;
        }

        return dp[n] + n;
    }
}
