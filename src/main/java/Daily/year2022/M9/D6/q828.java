package Daily.year2022.M9.D6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q828 {
    public int uniqueLetterString(String s) {
        // 计算每个字符对答案的贡献，s[i] 可作为多少个子数组的唯一元素
        Map<Character, List<Integer>> index = new HashMap<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(!index.containsKey(c)){
                index.put(c, new ArrayList<Integer>());
                index.get(c).add(-1);
            }

            index.get(c).add(i);
        }

        int ans = 0;
        for(Map.Entry<Character, List<Integer>> entry : index.entrySet()){
            List<Integer> arr = entry.getValue();
            arr.add(s.length());

            for(int i = 1; i < arr.size() - 1; i++){
                ans += (arr.get(i) - arr.get(i - 1)) * (arr.get(i + 1) - arr.get(i));
            }
        }

        return ans;
    }
}
