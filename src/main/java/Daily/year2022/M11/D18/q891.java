package Daily.year2022.M11.D18;

import java.util.Arrays;

public class q891 {
    public int sumSubseqWidths(int[] nums) {

        // 数学
        final int MOD = (int) 1e9 + 7;

        // 排序
        Arrays.sort(nums);

        long ans = 0L;

        long x = nums[0], y = 2;

        // Bj = nums[j] * (yj - 1) - xj
        // Bj+1  = nums[j + 1] *(yj+1 - 1) - x j+1
        for (int i = 1; i < nums.length; i++) {
            ans = (ans + (long) nums[i] * (y - 1) - x) % MOD;
            x = (x * 2 + nums[i]) % MOD;
            y = y * 2 % MOD;
        }

        return (int) ((ans + MOD) % MOD);
    }
}
