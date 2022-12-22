package WeekCompetition.year2022.DW90;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class q2451 {
    public String oddString(String[] words) {
        int n = words[0].length();

        int[] diff = new int[n - 1];

        Map<String, Integer> map = new HashMap<>();
        String cur = "";
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < words[i].length() - 1; j++) {
                diff[j] = words[i].charAt(j + 1) - words[i].charAt(j);
            }
            map.put(Arrays.toString(diff), i);
        }


        for(int i = 2; i < words.length; i++) {
            for(int j = 0; j < words[i].length() - 1; j++) {
                diff[j] = words[i].charAt(j + 1) - words[i].charAt(j);
            }
            cur = Arrays.toString(diff);
            if(map.size() == 1) {
                if(!map.containsKey(cur)) {
                    return words[i];
                }
            } else {
                // if key, map.keySet();
                // map.remove(cur);
                // return words[map.values().iterator().next()];
                // 这里可以直接先获取 cur 对应的是 0 还是 1
                return words[1 - map.get(cur)];
            }
        }

        return "";
    }
}
