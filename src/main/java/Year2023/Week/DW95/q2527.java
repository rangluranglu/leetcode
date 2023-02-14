package Year2023.Week.DW95;

public class q2527 {
    public int xorBeauty(int[] nums) {
        // ((nums[i] | nums[j]) & nums[k]) 0 <= i, j, k < n
        // 暴力超时 nums=[a, b, c]  3 ^ 3;


        // nums 的 xor 美丽值即为 nums 所有元素的异或值。

        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }
}
