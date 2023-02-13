package Year2023.Week.W332;

import java.util.Arrays;

public class q2563 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        // 统计公平数对，二分
        //
        long ans = 0;
        Arrays.sort(nums);
        // 枚举nums[j]
        // nums[i] >= lower - nums[j]
        // nums[i] <= upper - nums[j]
        // nums[i] 的范围， [lower - nums[j], upper-nums[j]]
        // <= upper-nums[j]的个数    >= upper-nums[j] + 1的第一个下表
        //  减去 < lower-nums[j] 的个数     >= lower-nums[j] 的第一个下标
        for (int j = 0; j < nums.length; j++) {
            int r = lowerBound(nums, j, upper - nums[j] + 1);
            int l = lowerBound(nums, j, lower - nums[j]);

            ans += r - l;
        }

        return ans;
    }

    private int lowerBound(int[] nums, int right, int target){
        int left = 0; // 开区间 [left, right)

        while (left < right){
            int mid = (left + right) >>> 1;

            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        return right;
    }
}
