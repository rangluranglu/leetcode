package Year2022.Week.W325;

public class q2518 {
    int mod = (int) 1e9 + 7;
    public int countPartitions(int[] nums, int k) {
        // 背包dp
        // 计算坏分区数目， 即有一个元素和小于k的方案数
        // dp[i][j] 表示从前i个数中选择若干元素，和为j的方案数
        //   不选第i个数：dp[i][j] = dp[i - 1][j]
        //    选第i个数：dp[i][j] = dp[i - 1][j - nums[i]]
        //   dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]]
        // 答案为所有分区的数目减去坏分区的数目，即 2^n-bad

        long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if(sum < k * 2){
            return 0;
        }

        // dp
        // k个
        int[] dp = new int[k];
        dp[0] = 1;
        int ans = 1;

        for(int num : nums){
            ans = ans * 2 % mod;
            for(int j = k - 1; j >= num; j--){
                dp[j] = (dp[j] + dp[j - num]) % mod;
            }
        }

        for(int x : dp){
            ans = (ans - x * 2 % mod + mod) % mod;
        }

        return ans;
    }
}
