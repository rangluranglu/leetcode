package Year2023.Week.W328;

import java.util.HashMap;
import java.util.Map;

public class q2537 {
    public long countGood(int[] nums, int k) {
        // 子数组 至少有k对
        // 滑动窗口

        // 统计窗口中的数字
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, n = nums.length, count = 0;
        long ans = 0;
        for(int right = 0; right < n; right ++){
            int x = nums[right];
            count += map.getOrDefault(x, 0);
            map.merge(x, 1, Integer::sum);
            while(count - map.get(nums[left]) + 1 >= k){
                count -= map.merge(nums[left], -1, Integer::sum);
                left ++;
            }

            // 每个右端点对应的答案个数为left + 1
            if(count >= k){
                ans += left + 1;
            }
        }

        return ans;
    }
}
