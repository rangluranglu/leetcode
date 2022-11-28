package Daily.year2022.M11.D28;

import java.util.Arrays;

public class q813 {
    public double largestSumOfAverages(int[] nums, int k) {
        // 动态规划

        // 均值和最大的分组的子数组数目必定是 k。
        // dp[i][j] 表示 [0 -- i] 分成j个子数组的最大平均和
        int n = nums.length;

        double[] prefix = new double[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = nums[i] + prefix[i];
        }
        double[][] dp = new double[n + 1][k + 1];
        // 初始化
        for (int i = 1; i <= n; i++) {
            dp[i][1] = prefix[i] / i;
        }

        for (int j = 2; j <= k; j++) {
            for (int i = j; i <= n; i++){
                for(int x = j - 1; x < i; x++){
                    dp[i][j] = Math.max(dp[i][j], dp[x][j - 1] + (prefix[i] - prefix[x]) / (i -x));
                }
            }
        }

        return dp[n][k];
        
    }
}
