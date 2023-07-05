package Year2023.Week.DW104;

import java.util.Arrays;

public class q2681 {

    private static  int MOD = (int) 1e9 + 7;
    public int sumOfPower(int[] nums) {
        // 分解问题：找到子数组的最大值和最小值

        // 贡献法

        // 排序
        Arrays.sort(nums);

        // 枚举x作为最大值 a b c d
        // a * 2 ^ 2 + b * 2 ^ 1 + c * 2 ^ 0  = s
        // 贡献为 d ^ 3 + d ^ 2 * s = d^2 * (d + s)

        // 枚举到e时
        // s = 2 * s + nums[i]

        long ans = 0, s = 0;
        for(long num : nums){
            ans = (ans + num * num % MOD * (num + s))  % MOD;

            s = (s * 2 + num) % MOD;
        }

        return (int) ans;
    }
}
