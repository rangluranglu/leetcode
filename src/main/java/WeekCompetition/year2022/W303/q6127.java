package WeekCompetition.year2022.W303;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class q6127 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(countExcellentPairs(nums, 3));

    }
    public static long countExcellentPairs(int[] nums, int k) {
        long ans = 0l;
        Set<Integer> vis = new HashSet<>();
        Map<Integer, Integer> cnt = new HashMap<>();

        for(int x : nums){
            if(!vis.contains(x)){
                vis.add(x);
                int i = Integer.bitCount(x);
                cnt.put(i, cnt.getOrDefault(i, 0) + 1);

            }
        }

        for(Map.Entry<Integer, Integer> x : cnt.entrySet()){
            for(Map.Entry<Integer, Integer> y : cnt.entrySet()){
                if(x.getKey() + y.getKey() >= k){
                    ans += (long) x.getValue() * y.getValue();
                }
            }
        }

        return ans;

    }
}
