package Year2023.Week.DW98;

import java.util.Arrays;

public class q2567 {
    public int minimizeSum(int[] nums) {
        // 最小化得分，最多修改2个元素的值
        Arrays.sort(nums);
        int n = nums.length;
        // 排序后 修改两个值，  最小得分可以为0， 只有三种

        return Math.min(Math.min(nums[n-3] - nums[0], nums[n-2] - nums[1]), nums[n-1] - nums[2]);
    }
}
