package WeekCompetition.year2022.W320;

public class q2478 {
    final int Mod = (int)1e9 + 7;
    public int beautifulPartitions(String s, int k, int minLength) {
        // 动态规划
        // dp[i][j] 是到达第i个字符并且将前面这一段子串分割成j个满足长度要求的子字符串的方案数
        // 如果第i个字符不能成为结尾 dp[i][*] = 0;
        // dp[i][j] += dp[k - 1][j - 1], if(ok[k, i])
        // 维护前缀和 dp[i][j] = g[i - minLength, j-1]

        int n =s.length();
        char[] arr = ("0" + s).toCharArray();

        int[][] dp = new int[n + 2][k + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            if(ok(arr[i])) continue;
            for (int j = 1; j <= k; j++) {
                for(int l = (j - 1) * minLength + 1; l <= i - minLength + 1; l++){
                    if(ok(arr[l])){
                        dp[i][j] = (int)(((long)dp[i][j] + dp[l - 1][j - 1]) % Mod);
                    }
                }
            }

        }
        return dp[n][k];
    }

    public int beautifulPartitions2(String s, int k, int minLength) {
        // 动态规划  优化
        // 外层循环有重复的计算
        int n =s.length();
        char[] arr = ("0" + s).toCharArray();
        int[][] dp = new int[n + 2][k + 1];
        dp[0][0] = 1;

        for(int j = 1; j <= k; j++){
            long sum = 0L;
            for (int i = minLength * j; i <= n; i++) {
                if(!ok(arr[i]))
                    dp[i][j] = (int) sum;

                if(ok(arr[i - minLength + 1]) && !ok(arr[i])){
                    dp[i][j] = (int) (dp[i][j] + dp[i - minLength][j - 1]) % Mod;
                }

                if(ok(arr[i - minLength + 1])){
                    sum = (sum + dp[i - minLength][j - 1]) % Mod;
                }
            }
        }

        return dp[n][k];


    }

    boolean ok(char x){
        if(x == '2' || x == '3' || x == '5' || x == '7'){
            return true;
        }

        return false;
    }
}
