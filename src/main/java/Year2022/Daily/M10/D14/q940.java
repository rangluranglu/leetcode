package Year2022.Daily.M10.D14;

import java.util.Arrays;

public class q940 {
    // 动态规划
    public int distinctSubseqII(String s) {
        // 不同的子序列
        int MOD = (int) 1e9 + 7;
        int[] last = new int[26];
        Arrays.fill(last, -1);

        int n = s.length();
        int[] f= new int[n];
        Arrays.fill(f, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                if(last[j] != -1){
                    f[i] = (f[i] + f[last[j]] % MOD);
                }
            }
            last[s.charAt(i) - 'a'] = i;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if(last[i] != -1){
                ans = (ans + f[last[i]]) % MOD;
            }
        }

        return ans;
    }

    public int distinctSubseqII2(String s) {
        // 不同的子序列
        int MOD = (int) 1e9 + 7;
        int[] g = new int[26];
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int total = 1;
            for (int j = 0; j < 26; j++) {
                total = (total + g[j]) % MOD;
            }
            g[s.charAt(i) - 'a'] = total;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans = (ans + g[i]) % MOD;
        }

        return ans;

    }

    public int distinctSubseqII3(String s) {
        // 不同的子序列
        int MOD = (int) 1e9 + 7;
        int[] g = new int[26];
        int n = s.length();
        int total = 0;

        for (int i = 0; i < n; i++) {
            int oi = s.charAt(i) - 'a';
            int prev = g[oi];

            g[oi] = (total + 1) % MOD;
            total = ((total + g[oi] - prev) % MOD + MOD) % MOD;
        }

        return total;

    }
}
