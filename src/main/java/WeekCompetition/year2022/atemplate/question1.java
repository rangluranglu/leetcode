package WeekCompetition.year2022.atemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class question1 {
    public int unequalTriplets(int[] nums) {
        Map<Integer, Integer> map  = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        if(map.size() < 3){
            return 0;
        }
        int[] value = new int[map.size()];
        int index = 0;

        for (int val : map.values()) {
            value[index] = val;
            index++;
        }

        int ans = 0;
        for (int i = 0; i < value.length - 2; i++) {
            for (int j = i + 1; j < value.length - 1; j++) {
                for(int k = j + 1; k < value.length; k++){
                    ans += (value[i] * value[j] * value[k]);
                }
            }
        }

        return ans;
    }
}
