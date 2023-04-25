package Year2023.Daily.M4.D24;

import javax.swing.plaf.metal.MetalTheme;

public class q1163 {
    public String lastSubstring(String s) {
        // 字典序
        // 只要考虑 ： 后缀子串即可
        // 我们使用指针 i 指向已知的最大后缀子字符串，j 指向待比较的后缀子字符串
        int i = 0, j = 1, n = s.length();

        while (j < n){
            int k = 0;
            while (j + k < n && s.charAt(j + k) == s.charAt(i + k)){
                k ++;
            }

            if(j + k < n && s.charAt(i + k) < s.charAt(j + k)){
                int t = i;
                i = j;

                // 更新j
                j = Math.max(j + 1, t + k + 1);
            }else {
                j = j + k + 1;
            }
        }

        return s.substring(i);




    }
}
