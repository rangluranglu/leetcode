package Daily.year2022.M11;

import java.util.ArrayDeque;
import java.util.Queue;

public class D17 {
    public int numMatchingSubseq(String s, String[] words) {
        // 多指针
        Queue<int[]>[] p = new Queue[26];

        for (int i = 0; i < 26; i++) {
            p[i] = new ArrayDeque<int[]>();
        }

        for (int i = 0; i < words.length; i++) {
            p[words[i].charAt(0) - 'a'].offer(new int[]{i, 0});
        }

        // 同时匹配
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int len = p[c - 'a'].size();
            // 匹配
            while (len > 0){
                int[] t = p[c - 'a'].poll();
                if(t[1] == words[t[0]].length() - 1){
                    ans++;
                }else {
                    t[1] ++;
                    p[words[t[0]].charAt(t[1]) - 'a'].offer(t);
                }
                len --;
            }


        }
        return ans;
    }
}
