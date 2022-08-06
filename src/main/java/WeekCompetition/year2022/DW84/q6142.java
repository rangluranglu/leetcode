package WeekCompetition.year2022.DW84;

import java.util.HashMap;
import java.util.Map;

public class q6142 {
    public static long countBadPairs(int[] nums) {

        int n = nums.length;
        long count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            map.put(nums[i] - i, map.getOrDefault(nums[i] - i, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                continue;
            }
            if(entry.getValue() == n){
                return 0l;
            }

            count += (long) entry.getValue() * (entry.getValue() - 1) / 2;
        }

        return (long) n * (n - 1) / 2 - count;

    }
}
