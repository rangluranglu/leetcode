package Year2023.Daily.M6.D27;

public class q1186 {
    public int maximumSum(int[] arr) {
        // 删还是不删， 如果全是正数不用删，最多删一个负数
        // 动态规划 dp[i][k] 表示以arr[i] 结尾删除k次的最大和

        // dp[i][0] = max(dp[i - 1][0], 0) + arr[i]
        // dp[i][1] = max(dp[i - 1][1] + arr[i], dp[i-1][0]

        int dp0 = arr[0], dp1 = 0, ans = arr[0];

        for (int i = 1; i < arr.length; i++) {
            dp1 = Math.max(dp1 + arr[i], dp0);
            dp0 = Math.max(dp0, 0) + arr[i];

            ans = Math.max(ans, Math.max(dp0, dp1));
        }
        return ans;
    }
}
