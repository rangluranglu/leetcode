package Year2023.Week.W349;

public class q2735 {
    public long minCost(int[] nums, int x) {
        // 理解题意
        // 如果不操作 第i个巧克力必须花费nums[i] 收集，总成本为nums[i] 的和
        // 操作一次 第i个巧克力 可以花费 min(nums[i], nums[i + 1])

        // 枚举 --> 优化

        int n = nums.length;
        long[] sum = new long[n];

        for (int i = 0; i < n; i++) {
            sum[i] = (long) i * x;  // 操作i次
        }

        for (int i = 0; i < n; i++) {
            int mn = nums[i];

            for(int j = i; j < n + i; j++){  // 子数组右端点
                mn = Math.min(mn, nums[j % n]);  // 从nums[i] 到 nums[j % n] 的最小值
                sum[j - i] += mn;  // 累加操作 j - i 次成本
            }
        }

        long ans = Long.MAX_VALUE;
        for(long s : sum){
            ans = Math.min(ans, s);
        }

        return ans;
    }
}
