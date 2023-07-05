package Year2023.Week.DW104;

public class q2680 {
    public long maximumOr(int[] nums, int k) {
        // 乘以2   x <<= 1
        // k次操作

        // 枚举 移动哪个数

        int n = nums.length;
        int[] suf = new int[n + 1];

        for (int i = n - 1; i > 0; i--) {
            suf[i] = suf[i + 1] | nums[i];
        }

        long ans = 0;
        for(int i = 0, pre = 0; i < n; i++){
            ans = Math.max(ans, pre | ((long) nums[i] << k) | suf[i + 1]);
            pre |= nums[i];
        }

        return ans;
    }
}
