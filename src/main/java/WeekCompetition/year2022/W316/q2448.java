package WeekCompetition.year2022.W316;

import java.util.Arrays;

public class q2448 {
    public long minCost(int[] nums, int[] cost) {
        // 枚举 + 考察变化量
        int n = nums.length;
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        // 排序
        Arrays.sort(index, (a, b) -> nums[a] == nums[b] ? cost[a] - cost[b] : nums[a] - nums[b]);

        long total = 0;
        // 都变为 0 的消耗
        for (int i = 0; i < n; i++) {
            total += (long) (nums[index[i]] - nums[index[0]]) * cost[index[i]];
        }

        long ans = total;
        long sum_cost = Arrays.stream(cost).sum();

        for (int i = 0; i < n - 1; i++) {
            int index1 = index[i];
            int index2 = index[i + 1];

            // 枚举变成的值
            // 已经都变成第一个值了
            sum_cost -= 2L * cost[index1];
            total -= (long) sum_cost * (nums[index2] - nums[index1]);
            ans = Math.min(ans, total);
        }
        return ans;

    }
    // 三分法求凸函数的最小值
    public long minCost2(int[] nums, int[] cost) {
        // 枚举 + 考察变化量
        int minValue = Arrays.stream(nums).min().getAsInt();
        int maxValue = Arrays.stream(nums).max().getAsInt();

        return 0L;
    }

}
