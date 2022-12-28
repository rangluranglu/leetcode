package WeekCompetition.year2022.DW94;

import java.util.Arrays;

public class q2514 {
    int MOD = (int) 1e9 + 7;
    public int countAnagrams(String s) {
        // 同位异构

        char[] chs = s.toCharArray();
        long ans = 1L, mul = 1L;

        int[] cnt = new int[26];

        for (int i = 0, j = 0; i < chs.length; i++) {
            if(chs[i] == ' '){
                Arrays.fill(cnt, 0);
                j = 0;
            }else {
                mul = mul * ++cnt[chs[i] - 'a'] % MOD;
                ans = ans * ++ j % MOD;
            }
        }

        // 费马小定理
        // a / b(mod p) = a * pow(b,p-2)mod p
        return (int) (ans * pow(mul, MOD - 2) % MOD);
    }

    private long pow(long x, int n){
        long res = 1L;
        for(; n > 0; n /= 2){
            if(n % 2 > 0){
                res = res * x % MOD;
            }
            x = x * x % MOD;
        }
        return res;
    }
}
