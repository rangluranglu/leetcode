package WeekCompetition.year2022.DW91;

public class q2466 {
    public int countGoodStrings(int low, int high, int zero, int one) {
        // zero 个 0 和 one 个 1 随意组合，生成的字符串的长度 在 low 和 high 之间
        // 背包问题

        // low <= a * zero +b * one <= high;

        // 确定a， b 的组合数
        // 爬楼梯

        // dp[i] = dp[i - zero] + dp[i - one];

        int MOD = (int) 1e9 + 7;
        int[] dp = new int[high + 1];
        dp[0] = 1;

        for (int i = 1; i <= high; i++) {
             int a = i >= zero ? dp[i - zero] : 0;
             int b = i >= one ? dp[i - one] : 0;
             dp[i] = (a + b ) % MOD;
        }

        int ans = 0;
        for(int i = low; i <= high; i++){
            ans = (ans + dp[i]) % MOD;
        }

        return ans;
    }
}
