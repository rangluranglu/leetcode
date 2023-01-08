package Year2023.Daily.M1.D7;

import java.util.Arrays;

public class q1658 {
    public int minOperations(int[] nums, int x) {
        // 滑动窗口，长度最长 使 s = sum - x

        int target = Arrays.stream(nums).sum() - x;;
        if(target < 0){
            return -1;
        }
        if(target == 0){
            return nums.length;
        }

        int ansSum = 0, left = 0, ans = 0;

        for (int right = 0; right < nums.length; right++) {
            ansSum += nums[right];

            while (left <= right && ansSum > target){
                ansSum -= nums[left ++];
            }


            if(ansSum == target){
                ans = Math.max(ans, right - left + 1);
                ansSum -= nums[left ++];
            }
        }

        return ans == 0 ? -1 : nums.length - ans;
    }
}
