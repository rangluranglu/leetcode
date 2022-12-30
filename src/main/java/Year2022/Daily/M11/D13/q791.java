package Year2022.Daily.M11.D13;

import java.util.Arrays;

public class q791 {
    public String customSortString(String order, String s) {
        int[] val = new int[26];
        for (int i = 0; i < order.length(); i++) {
            val[order.charAt(i) - 'a'] = i + 1;

        }

        Character[] chars = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        Arrays.sort(chars, (a,b) -> val[a - 'a'] - val[b - 'a']);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(chars[i]);
        }

        return sb.toString();
    }


    public String customSortString2(String order, String s) {
        // 计数排序
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a'] ++;

        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            while(freq[ch - 'a'] > 0){
                ans.append(ch);
                freq[ch - 'a'] --;
            }
        }

        for (int i = 0; i < 26; i++) {
            while(freq[i]>0){
                ans.append((char) i + 'a');
                freq[i] --;
            }
        }

        return ans.toString();
    }
}
