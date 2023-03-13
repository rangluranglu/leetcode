package Year2023.Week.W336;

import java.util.HashMap;
import java.util.Map;

public class q2588 {
    public long beautifulSubarrays(int[] nums) {
        // 美丽子树组的数目  nums[i] 和 nums[j] 在二进制下第k位 是 1

        // 统计每位是1 的个数， 子数组 1 的个数是偶数
        // length <= 10^5   ,   nums[i] <= 10 ^ 6
        // 子数组， 前缀和

        // 异或 ？？ -->> 不同是1 ， 相同是 0

        // 边界
        Map<Long, Long> map = new HashMap<>();

        long ans = 0;
        long preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum ^= nums[i];
            if(preSum == 0){
                ans += 1;
            }
            if(map.containsKey(preSum)){
                ans += map.get(preSum);
                map.put(preSum, map.get(preSum) + 1);
            }else {
                map.put(preSum, 1L);
            }
        }

        return ans;

    }
}
