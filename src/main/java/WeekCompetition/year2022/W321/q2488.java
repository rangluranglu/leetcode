package WeekCompetition.year2022.W321;

import java.util.HashMap;
import java.util.Map;

public class q2488 {
    public int countSubarrays(int[] nums, int k) {
        // 简化
        int n = nums.length;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] < k){
                nums[i] = 0;
            }else if(nums[i] == k){
                nums[i] = 1;
                index = i;
            }else{
                nums[i] = 2;
            }
        }

        // 求 含 1个1  0和2的个数相等， 或 0的个数小于2的个数的子数组数目
        // dp[i][j] 标识 i - j 的
        Map<Integer, Integer> pre = new HashMap<>();
        int ans = 1;

        int less = 0, more = 0;
        for(int i = index - 1; i >= 0; i--){
            // 统计
            if(nums[i] < 1){
                less ++;
            }else {
                more ++;
            }
            if(more - less == 1 || more == less){
                ans ++;
            }
            pre.put(less - more, pre.getOrDefault(less - more, 0) +1);
        }

        less = 0;
        more = 0;

        for (int i = index + 1; i< n; i++){
            if(nums[i] < 1){
                less ++;
            }else {
                more ++;
            }
            if(more - less == 1 || more == less){
                ans ++;
            }

            int key = more - less;
            ans += pre.getOrDefault(key, 0);
            ans += pre.getOrDefault(key - 1, 0);
        }

        return ans;
    }
}
