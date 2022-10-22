package Daily.year2022.M10.D22;

import java.util.Arrays;

public class q1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][];
        for (int i = 0; i < n; i++) {
            jobs[i]  = new int[]{startTime[i], endTime[i], profit[i]};
        }
        // endTime 递增
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            // 其中 k 表示满足结束时间小于等于第 i−1 份工作开始时间的兼职工作数量
            int k = binarySearch(jobs, i -1, jobs[i-1][0]);
            // 前i份工作可以获得的最大报酬
            dp[i] = Math.max(dp[i - 1], dp[k] + jobs[i - 1][2]);
        }

        return dp[n];
    }

    public int binarySearch(int[][] jobs, int right, int target){
        int left = 0;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(jobs[mid][1] > target){
                right = mid;
            }else {
                left = mid + 1;
            }
        }

        return left;
    }
}
