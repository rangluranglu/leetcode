package question;

import java.util.Arrays;

public class q28 {
    public int strStr(String haystack, String needle) {
        // kmp 算法
        // 模式串前缀函数
        int m = haystack.length();
        int n = needle.length();

        int[] pi = new int[n];
        // 模式串前缀函数
        for(int i = 1; i < n; i++){
            int j = pi[i - 1];

            while(j > 0 && needle.charAt(i) != needle.charAt(j)){
                j = pi[j - 1];
            }
            if(needle.charAt(i) == needle.charAt(j)){
                j ++;
            }
            pi[i] = j;
        }


        // System.out.println(Arrays.toString(pi));
        int[] si = new int[m];
        // 开始匹配
        for(int i = 0, j = 0; i < m; i++){
            while(j > 0 && haystack.charAt(i) != needle.charAt(j)){
                // 字符串不相等， 但是前p[j - 1] 个字符串一定是已经匹配好的，所以给j赋值，不需要从头开始匹配
                //System.out.println("1" + j);
                j = pi[j - 1];
            }
            // System.out.println(j);
            if(haystack.charAt(i) == needle.charAt(j)){
                // System.out.println(i);
                j++;
                // System.out.println(j);
            }

            if(j == n){
                return i - n + 1;
            }
        }

        return -1;
    }
}
