package Year2023.Week.DW101;

import java.util.HashMap;
import java.util.Map;

public class q2606 {
    public int maximumCostSubstring(String s, String chars, int[] vals) {

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < vals.length; i++){
            map.put(chars.charAt(i), vals[i]);
        }

        // 子串
        int ans = 0, cur = 0;

        for (int i = 0; i < s.length(); i++) {
            cur += map.getOrDefault(s.charAt(i), s.charAt(i) - 'a' + 1);
            if(cur < 0){
                cur = 0;
            }else {
                ans = Math.max(cur, ans);
            }
        }

        return ans;
    }
}
