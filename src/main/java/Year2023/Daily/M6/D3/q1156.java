package Year2023.Daily.M6.D3;

import java.util.HashMap;
import java.util.Map;

public class q1156 {
    public int maxRepOpt1(String text) {
        // 如何最长, 相同字符间隔为1， 长度分别为
        // 如果长度> n/ 2 可以提前返回
        Map<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }


    }
}
