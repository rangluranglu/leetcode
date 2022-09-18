package Daily.year2022.M9.D12;

import java.util.Arrays;

public class q1608 {
    public static void main(String[] args) {
        int[] nums = {3, 6, 7, 7, 0};
        System.out.println(specialArray(nums));
    }
    public static int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        for (int i = 1; i <= n; ++i) {
            if (nums[i - 1] >= i && (i == n || nums[i] < i)) {
                return i;
            }
        }
        return -1;
    }
}
