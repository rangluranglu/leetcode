package Year2023.Daily.M1.D17;

import java.util.HashMap;
import java.util.Map;

public class q1814 {
    public int countNicePairs(int[] nums) {
        // nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
        // f(i) = nums[i] - rev(nums[i])
        // f(i) = f(j)
        int MOD = (int)1e9 + 7;
        int res = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            int temp = i, j = 0;

            while(temp > 0){
                j = j * 10 + temp % 10;
                temp /= 10;
            }

            // j是反转过后的
            res = (res + map.getOrDefault(i - j, 0)) % MOD;
            map.put(i - j, map.getOrDefault(i - j, 0) + 1);
        }

        return res;
    }
}
