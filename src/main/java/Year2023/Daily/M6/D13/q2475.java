package Year2023.Daily.M6.D13;

import java.util.HashMap;
import java.util.Map;

public class q2475 {
    public int unequalTriplets(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 两两不同
        int n = nums.length;
        int prev = 0;
        int ans = 0;

        for (Integer value : map.values()) {
            n -= value;
            ans += prev * value * n;
            prev += value;
        }

        return ans;
    }
}
