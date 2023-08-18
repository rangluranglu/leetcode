package Year2023.Daily.M8.D18;

import java.util.Arrays;

public class q1388 {
    public int maxSizeSlices(int[] slices) {
        // 选择n个数， n个数字不能相邻

        // 动态规划 dp[i][j] 前i个数中选择了j个不相邻的数
        // 环状数组 第一个和最后一个不能同时选
        int n = slices.length - 1;
        int[] v1 = new int[n - 1];
        int[] v2 = new int[n - 1];

        System.arraycopy(slices, 1, v1, 0, n - 1);
        System.arraycopy(slices, 0, v1, 0, n - 1);

        return Math.max(calculate(v2), calculate(v1));
    }

    public int calculate(int[] slices){

        // dp
        int n = (slices.length + 1) / 3;
        int[][] dp = new int[slices.length][n + 1];

        // 初始化
        for(int i = 0; i < slices.length; i++){
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        dp[0][0] = 0;
        dp[0][1] = slices[0];
        dp[1][0] = 0;
        dp[1][1] = Math.max(slices[0], slices[1]);


        for(int i = 2; i < slices.length; i++){
            dp[i][0] = 0;

            for(int j = 1; j <= n; j++){
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 2][j - 1] + slices[i]);
            }
        }

        return dp[slices.length - 1][n];
    }
}
