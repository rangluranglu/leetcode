package WeekCompetition.year2022.W312;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q6190 {
    public static void main(String[] args) {
        int[] a = {2, 1, 1, 1, 3, 4, 1};
        System.out.println(goodIndices(a, 2));
    }
    public static List<Integer> goodIndices(int[] nums, int k) {
        // 前边非递增， 就是递减或者相等
        // 后边非递减， 就是递增或者相等

        int n = nums.length;
        if(2 * k + 1 > n){
            return new ArrayList<>();
        }
        // 以i为结尾的非递增长度
        int[] left = new int[n];
        // 非递减
        int[] right = new int[n];
        left[0] = 1;
        right[0] = 1;
        for (int i = 1; i < n; i++) {
            if(nums[i] <= nums[i - 1]){
                left[i] = left[i - 1] + 1;
            }else {
                left[i] = 1;
            }


            if(nums[i] >= nums[i - 1]){
                right[i] = right[i - 1] + 1;
            }else {
                right[i] = 1;
            }
        }

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        List<Integer> ans = new ArrayList<>();
        for (int i = k; i < n - k; i++) {
            if(left[i - 1] >= k && right[i + k] >= k){
                ans.add(i);
            }
        }

        return ans;

    }
}
