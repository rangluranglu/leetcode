package Year2023.Daily.M3.D26;

import java.util.HashSet;
import java.util.Set;

public class q2395 {
    public boolean findSubarrays(int[] nums) {
        int n = nums.length;

        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < n - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            if(!seen.add(sum)){
                return true;
            }
        }

        return false;
    }
}
