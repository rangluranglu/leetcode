package WeekCompetition.year2022.W324;

import java.util.HashMap;
import java.util.Map;

public class q2506 {
    public int similarPairs(String[] words) {
        // 状态压缩
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(String word : words){
            int mask = 0;
            for(char c : word.toCharArray()){
                mask |=  (1 << (c - 'a'));
            }

            ans += map.getOrDefault(mask, 0);
            map.put(mask, map.getOrDefault(mask, 0) + 1);
        }

        return ans;
    }
}
