package Year2023.Week.W350;

import java.util.Arrays;

public class q2740 {
    public int findValueOfPartition(int[] nums) {
        // 找出分区值， 分区值最小 min(|max(nums1) - min(nums2)|)

        Arrays.sort(nums);

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 1; i++){
            ans = Math.min(nums[i + 1] - nums[i], ans);
        }

        return ans;
    }
}
