package Year2023.Week.atemplate;

import java.lang.reflect.Array;
import java.util.*;

public class question2 {
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
