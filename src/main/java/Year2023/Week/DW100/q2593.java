package Year2023.Week.DW100;

import java.util.Arrays;

public class q2593 {
    public long findScore(int[] nums) {
        int n = nums.length;

        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]);

        long ans = 0L;
        // 标记后
        for(int i = 0; i < n; i++){
            if(nums[idx[i]] == 0){
                continue;
            }

            ans += nums[idx[i]];
            nums[idx[i]] = 0;
            if(idx[i] - 1 >= 0) nums[idx[i] - 1] = 0;
            if(idx[i] + 1 < n) nums[idx[i] + 1] = 0;
        }

        return ans;
    }


    public long findScore2(int[] nums) {
        // O（n） 时间复杂度
        // 查找严格递减的子段

        long ans = 0;

        for (int i = 0, n = nums.length; i < n; i += 2) {
            int i0 = i;
            while (i + 1 < n && nums[i] > nums[i + 1]){
                i ++;
            }

            for(int j = i; j >= i0; j  -= 2){
                ans += nums[j];
            }
        }

        return ans;
    }
}
