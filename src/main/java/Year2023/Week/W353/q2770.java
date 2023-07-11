package Year2023.Week.W353;

import java.util.Arrays;

public class q2770 {
    public int maximumJumps(int[] nums, int target) {
        // 最大跳跃次数
        // n个整数，贪心，调到最近满足条件
        int n = nums.length, ans = 0;
        int[] dp = new int[n]; // 结尾为i的最大跳跃次数
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i = 1; i < n; i ++){
            for(int j = 0; j < i; j++){
                if(nums[j] > 0 && nums[i] - nums[j] <= target && nums[i] - nums[j] >= -target){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[n - 1];
    }
}
