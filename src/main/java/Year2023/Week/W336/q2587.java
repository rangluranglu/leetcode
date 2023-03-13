package Year2023.Week.W336;

import java.util.Arrays;

public class q2587 {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        long preSum = 0;
        int ans = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            preSum += nums[i];

            if(preSum > 0){
                ans ++;
            }

            if(preSum < 0){
                break;
            }
        }

        return ans;
    }
}
