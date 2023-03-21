package Year2023.Daily.M3.D20;

import java.util.Arrays;

public class q1012 {
    int[][] dp;
    public int numDupDigitsAtMostN(int n) {
        // [1, n] 至少1位重复数字的个数
        // 数位dp， 总个数 减去 没有重复数字的个数
        // n + 1 - x

        String sn = String.valueOf(n);
        dp = new int[sn.length()][1 << 10];

        for(int i = 0; i < sn.length(); i++){
            Arrays.fill(dp[i], -1);
        }

        return n + 1 - f(0, sn, 0, true);
    }

    public int f(int mask, String sn, int i, boolean same){
        if(i == sn.length()){
            return 1;
        }

        if (!same && dp[i][mask] >= 0) {
            return dp[i][mask];
        }
        int res = 0, t = same ? (sn.charAt(i) - '0') : 9;
        for (int k = 0; k <= t; k++) {
            if ((mask & (1 << k)) != 0) {
                continue;
            }
            res += f(mask == 0 && k == 0 ? mask : mask | (1 << k), sn, i + 1, same && k == t);
        }
        if (!same) {
            dp[i][mask] = res;
        }
        return res;
    }


}
