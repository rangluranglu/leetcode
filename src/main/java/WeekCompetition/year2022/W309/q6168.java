package WeekCompetition.year2022.W309;

import java.util.Arrays;

public class q6168 {
    public static void main(String[] args) {
        System.out.println(numberOfWays(989, 1000, 99));
    }
    public static int numberOfWays(int startPos, int endPos, int k) {
        int mod = (int) 10e8 +7;
        // 正方向走了 a 步，往负方向走了 (k - a) 步后到达 endPos100000000

        int dis = Math.abs(endPos - startPos);
        if(dis == k){
            return 1;
        }else if(dis > k || ((k + dis) % 2 == 1)){
            return 0;
        }else {
            // 计算
            long[][] dp = new long[k + 1][k + 1];

            for (int i = 0; i <= k; i++){
                dp[i][0] = 1;
                for(int j = 1;j <= i; j++){
                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % mod;
                }
            }
            System.out.println(Arrays.deepToString(dp));
            return (int) dp[k][(dis + k) / 2] % mod;
        }
    }

}
