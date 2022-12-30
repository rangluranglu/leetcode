package Year2022.Daily.M10.D18;

public class q902 {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        // 数位DP
        // dp[i][2] dp[i][0]表示有digits 构成且小于n的前i位的数字的个数
        // 状态转移
        // i == 0  dp[i][0] = C[i]
        // i > 1   dp[i][0] = m + dp[i - 1][0] * m + dp[i - 1][1] * C[i]

        String s = Integer.toString(n);

        int m = digits.length, k = s.length();
        int[][] dp = new int[k + 1][2];
        dp[0][1] = 1;

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < m; j++) {
                if(digits[j].charAt(0) == s.charAt(i - 1)){
                    // 相等
                    dp[i][1] = dp[i - 1][1];
                }else if(digits[j].charAt(0) < s.charAt(i - 1)){
                    dp[i][0] += dp[i - 1][1];
                }else {
                    break;
                }
            }

            if(i > 1){
                // ？
                dp[i][0] += m + dp[i - 1][0] * m;
            }
        }

        return dp[k][0] + dp[k][1];

    }
}
