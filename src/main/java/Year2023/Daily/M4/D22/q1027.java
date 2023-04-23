package Year2023.Daily.M4.D22;

import java.util.Arrays;

public class q1027 {
    public int longestArithSeqLength(int[] nums) {
        // 最长等差子序列

        // 动态规划 dp[i][d][num]  --> 数组中下标小于等于i的元素，构造公差为d的等差数列，最后一个元素为num时的长的
        // 不加入 dp[i][d][num] <-- dp[i - 1][d][num]
        // 加入  dp[i][d][nums[i]] <-- dp[i - 1][d][nums[i] - d] + 1

        int maxV = Arrays.stream(nums).max().getAsInt();
        int minV = Arrays.stream(nums).min().getAsInt();

        int diff = maxV - minV;

        int ans = 1;

        for(int d = -diff; d <= diff; d++){
            int[] dp = new int[maxV + 1];
            for(int num : nums){
                int prev = num - d;
                if(prev >= minV && prev <= maxV && dp[prev] != 0){
                    dp[num] = Math.max(dp[num], dp[prev] + 1);
                    ans = Math.max(ans, dp[num]);
                }

                dp[num] = Math.max(dp[num], 1);
            }

        }

        return ans;
    }
}
