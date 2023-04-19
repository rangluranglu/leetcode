package Year2023.Daily.M4.D19;

public class q1043 {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // 分隔长度最多为k的子数组
        // 返回元素和最大

        // 动态规划


        int n = arr.length;
        int[] dp = new int[n + 1];

        for(int i = 0; i < n; i++){
            for(int j = i, mx = 0; j > i - k && j >= 0; j--){
                mx = Math.max(mx, arr[j]);

                dp[i + 1] = Math.max(dp[i + 1], dp[j] + mx * (j - i + 1));
            }
        }
        return dp[n];
    }
}
