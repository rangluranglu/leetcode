package Year2023.Daily.M3.D16;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class q2488 {
    public int countSubarrays(int[] nums, int k) {
        // 中位数为k的， 子数组数目  数组由 1 到 n 的 的不同子树构成
        // 中位数 (n + 1) / 2 - 1;

        // 前缀和 --> 先找到kIndex
        // 数组start <= kIndex nad end >= kIndex
        // 子数组中 大于k的个数 - 小于k的个数  为 0或1

        int n = nums.length;
        int kIndex = -1;

        for (int i = 0; i < n; i++) {
            if(nums[i] == k){
                kIndex = i;
                break;
            }
        }

        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += count(nums[i] - k);

            if(i < kIndex){
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }else {
                int prev0 = map.getOrDefault(sum, 0);
                int prev1 = map.getOrDefault(sum - 1, 0);

                ans += prev0 + prev1;
            }
        }

        return ans;



    }


    private int count(int num){
        if(num == 0){
            return 0;
        }

        return num > 0 ? 1 : -1;
    }
}
