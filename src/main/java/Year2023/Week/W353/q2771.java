package Year2023.Week.W353;

public class q2771 {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        // 最长非递减子数组， 递增
        // 贪心, 选最小值
        int n = nums1.length;
        int[][] dp = new int[n][2];   // dp，以i为结尾的最长长度
        dp[0][0] = 1;
        dp[0][1] = 1;
        int ans = 1;
        for(int i = 1; i < n; i++){
            dp[i][0] = 1;
            dp[i][1] = 1;
            if(nums1[i] >= nums1[i - 1]){
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][0] + 1);
            }

            if(nums2[i] >= nums1[i - 1]){
                dp[i][1] = Math.max(dp[i][1], dp[i - 1][0] + 1);
            }

            if(nums1[i] >= nums2[i - 1]){
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][1] + 1);
            }

            if(nums2[i] >= nums2[i - 1]){
                dp[i][1] = Math.max(dp[i][1], dp[i - 1][1] + 1);
            }
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }

        return ans;
    }
}
