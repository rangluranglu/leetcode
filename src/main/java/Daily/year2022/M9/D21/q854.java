package Daily.year2022.M9.D21;

import java.util.*;

public class q854 {
    char[] target;
    int ans = Integer.MAX_VALUE;
    public int kSimilarity(String s1, String s2) {
        // 交换位置
        target = s2.toCharArray();
        // 回溯
        backtrace(s1.toCharArray(), 0, 0);
        return ans;
    }


    public void backtrace(char[] s1, int index, int count){
        if(index == s1.length){
            ans = Math.min(count, ans);
            return ;
        }

        if(count >= ans){
            return;
        }

        if(s1[index] != target[index]){
            // 回溯
            for (int i = index + 1; i < s1.length; i++) {
                if(s1[i] == target[index] && s1[i] != target[i]){
                    swap(s1, i, index);
                    backtrace(s1, index + 1, count + 1);
                    swap(s1, i, index);
                }
            }
        }else {
            backtrace(s1, index + 1, count);
        }
    }


    private void swap(char[] s, int i, int j){
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
