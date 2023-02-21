package Year2023.Daily.M2.D21;

import java.util.Arrays;

public class q1326 {
    public int minTaps(int n, int[] ranges) {
        // 动态规划

        // 求选择最少区间数目可以覆盖连续区间[0,n]。
        // dp[i] 为覆盖区间[0, i]所需要的最少区间数目。
        // 转移：dp[i] = min(dp[i], 1 + dp[start_j])

        int[][] intervals = new int[n + 1][];
        for (int i = 0; i <= n; i++) {
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);
            intervals[i] = new int[]{start, end};
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] dp = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for(int[] interval : intervals){
            int start = interval[0], end = interval[1];

            if(dp[start] == Integer.MAX_VALUE){
                return -1;
            }

            for(int j = start; j <= end; j++){
                dp[j] = Math.min(dp[j], dp[start] + 1);
            }
        }

        return dp[n];
    }
}
