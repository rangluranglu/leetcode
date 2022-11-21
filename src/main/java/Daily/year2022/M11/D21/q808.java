package Daily.year2022.M11.D21;

import sun.nio.cs.ext.MacHebrew;

public class q808 {

    public double soupServings(int n) {
        // 与前一种状态有关，动态规划
        // dp(i, j) 表示A和B 分别剩下 i， j 份时所求的概率值

        // 当 i > 0, j = 0; 无法完成分配， dp(i, j) = 0;
        // 当 i = 0, j = 0; 同时分配完毕， dp(i, j) = 1.0 * 0.5
        // 当 i = 0, j > 0; 无法再分配，汤A先分配完成的概率为1， dp(i, j) = 1；
        n = (int) Math.ceil((double) n / 25);

        if(n >= 179){
            return 1.0;
        }

        double[][] dp = new double[n + 1][n + 1];
        dp[0][0] = 0.5;

        for (int i = 1; i <= n; i++) {
            dp[0][i] = 1.0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[Math.max(0, i - 4)][j] + dp[Math.max(0, i -3)][Math.max(0, j - 1)] + dp[Math.max(0, i - 2)][Math.max(0, j - 2)] + dp[Math.max(0, i - 1)][Math.max(0, j - 3)]) / 4.0;
            }
        }

        return dp[n][n];
    }
}
