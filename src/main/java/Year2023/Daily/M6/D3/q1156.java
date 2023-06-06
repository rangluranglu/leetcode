package Year2023.Daily.M6.D3;

import java.util.HashMap;
import java.util.Map;

public class q1156 {
    public int maxRepOpt1(String text) {
        // 如何最长, 相同字符间隔为1， 长度分别为
        // 如果长度> n/ 2 可以提前返回
        // 使用map存储长度

        int n = text.length();
        Map<Character, Integer> count = new HashMap<>();

        // 统计每个字符的总个数
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        int ans = 0;
        // 遍历同一字符长度
        for(int i = 0; i < n; ){
            int len = 1;
            while (i +len < n && text.charAt(i) == text.charAt(i + len)){
                len ++;
            }


            // 长度  并且有空位
            if(len < count.getOrDefault(text.charAt(i), 0)  && (i + len < n || i > 0)){
                ans = Math.max(len, ans);
            }

            // 隔一个字符是否有相同字符
            int k = i + len + 1;
            while(k < n && text.charAt(k) == text.charAt(i)){
                k ++;
            }

            ans = Math.max(ans, Math.min(k - i, count.getOrDefault(text.charAt(i), 0)));
            i = i + len;
        }

        return ans;
    }
}
