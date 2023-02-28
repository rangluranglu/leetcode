package Year2023.Daily.M2.D27;

public class q1144 {
    public int movesToMakeZigzag(int[] nums) {
        // 两种方案：奇数和偶数

        return Math.min(help(nums, 1), help(nums, 0));
    }

    public int help(int[] nums, int pos) {
        int res = 0;
        for (int i = pos; i < nums.length; i += 2) {
            int a = 0;
            if (i - 1 >= 0) {
                a = Math.max(a, nums[i] - nums[i - 1] + 1);
            }
            if (i + 1 < nums.length) {
                a = Math.max(a, nums[i] - nums[i + 1] + 1);
            }
            res += a;
        }
        return res;
    }
}
