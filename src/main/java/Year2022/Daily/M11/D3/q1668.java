package Year2022.Daily.M11.D3;

import java.util.Arrays;

public class q1668 {
    public int maxRepeating(String sequence, String word) {
        // kpm 算法

        int n = sequence.length();
        int m = word.length();

        if(n < m){
            return 0;
        }

        int[] pi = new int[m];
        // kmp 算法
        // 首先建立模式串前缀函数
        for (int i = 1; i < m; i++) {
            int j = pi[i - 1];
            while(j > 0 && word.charAt(i) != word.charAt(j)){
                j = pi[j - 1];
            }

            if(word.charAt(i) == word.charAt(j)){
                j++;
            }
            pi[i] = j;
        }

        System.out.println(Arrays.toString(pi));

        // 动态规划
        int[] dp = new int[n];
        // 对比
        int j = 0;

        for (int i = 0; i < n; i++) {
            while (j > 0 && word.charAt(j) != sequence.charAt(i)){
                j = pi[j - 1];
            }

            if(word.charAt(j) == sequence.charAt(i)){
                j ++;
                // 到达串尾
                if(j == m){
                    dp[i] = (i >= m ? dp[i - m] : 0) + 1;
                    j = pi[j - 1];
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();


    }
}
