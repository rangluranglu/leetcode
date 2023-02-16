package question;

import java.util.ArrayList;
import java.util.List;

public class q438 {

    public List<Integer> findAnagrams(String s, String p) {
        // 异位词

        // 滑动窗口
        int n = s.length();
        int[] target = new int[26];
        for (int i = 0; i < p.length(); i++) {
            target[p.charAt(i) - 'a'] ++;
        }

        List<Integer> list = new ArrayList<>();
        int[] count = new int[26];
        int left = 0;

        for(int right = 0; right < n; right++){
            count[s.charAt(right) - 'a'] ++;

            // -1 清除， 1 可以， 0 跳过
            int res = check(target, count);
            if(res ==  1){
                list.add(left);
                count[s.charAt(left) - 'a'] --;
                left = left + 1;
            }else if(res == -1){
                count[s.charAt(left) - 'a'] --;
                left = left + 1;
            }
        }

        return list;
    }

    public void clear(int[] count){
        for (int i = 0; i < 26; i++) {
            count[i] = 0;
        }
    }


    public int check(int[] target, int[] count){
        boolean flag = true;
        for (int i = 0; i < 26; i++) {
            if(count[i] > target[i]){
                return -1;
            }
            if(target[i] != count[i]){
                flag = false;
            }
        }

        return flag ? 1 : 0;
    }
}
