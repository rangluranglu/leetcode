package question;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class q76 {
    public String minWindow(String s, String t) {
        // s 中涵盖 t 所有字符的最小子串

        // 滑动窗口
        if(s.length() < t.length()){
            return "";
        }
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> count = new HashMap<>();

        int m = s.length(), n = t.length();

        for (int i = 0; i < n; i++) {
            target.put(t.charAt(i), target.getOrDefault(t.charAt(i), 0) + 1);
        }

        // 滑动窗口
        int left = 0;
        int ans = Integer.MAX_VALUE;
        int ansL = 0, ansR = 0;
        for (int right = 0; right < m; right++) {
            if(target.containsKey(s.charAt(right))){
                count.put(s.charAt(right), count.getOrDefault(s.charAt(right), 0) + 1);
            }

            while (check(target, count) && left <= right){
                // 相等
                if(right - left + 1 < ans){
                    ans = right - left + 1;
                    ansL = left;
                    ansR = right + 1;
                }
                if(target.containsKey(s.charAt(left))){
                    count.put(s.charAt(left), count.getOrDefault(s.charAt(left), 0) - 1);
                }
                left ++;
            }
        }
        return s.substring(ansL, ansR);
    }

    private boolean check(Map<Character, Integer> target, Map<Character, Integer> count){
        // 判断
        if(target.size() != count.size()){
            return false;
        }

        for (Map.Entry<Character, Integer> entry : target.entrySet()) {
            Character k = entry.getKey();
            if(count.get(k) < entry.getValue()){
                return false;
            }
        }

        return true;
    }
}
