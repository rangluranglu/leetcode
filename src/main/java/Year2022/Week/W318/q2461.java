package Year2022.Week.W318;

import java.util.HashSet;
import java.util.Set;

public class q2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        // 滑动窗口， 哈希表维护次数

        Set<Integer> set = new HashSet<>();

        int left = 0, n = nums.length;
        long ans = 0L, sum = 0L;

        for (int righ = 0; righ < n; righ++) {
            while(set.contains(nums[righ])){
                set.remove(nums[left]);
                sum -= nums[left ++];
            }

            set.add(nums[righ]);
            sum += nums[righ];

            if(righ - left + 1 == k){
                ans = Math.max(ans, sum);
                set.remove(nums[left]);
                sum -= nums[left ++];
            }
        }
        return ans;
    }
}
