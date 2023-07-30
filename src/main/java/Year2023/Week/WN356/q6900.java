package Year2023.Week.WN356;

import java.util.HashMap;
import java.util.Map;

public class q6900 {
    public int countCompleteSubarrays(int[] nums) {
        // 子数组
        // 计算贡献


        // 小于1000  dp
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> count = new HashMap<>();
        int left = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);

            if(count.size() == map.size()){
                while (count.get(nums[left]) >= 2){
                    count.put(nums[left], count.get(nums[left]) - 1);
                    left ++;
                }
                ans += (left + 1);
            }
        }

        return ans;
    }
}
