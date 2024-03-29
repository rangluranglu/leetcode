package Year2023.Daily.M7.D1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class q1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{i, map.get(target - nums[i])};
            }

            map.put(nums[i], i);
        }


        return new int[0];
    }
}
