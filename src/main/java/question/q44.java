package question;

public class q44 {
    public boolean isMatch(String s, String p) {
        if("*".equals(p)){
            return true;
        }

        // 动态规划
        int m =  s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if(p.charAt(i - 1) == '*'){
                dp[0][i] = true;
            }else {
                break;
            }
        }

        for (int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++){
                if(s.charAt(i - 1) == p.charAt(j - 1)){
                    // 字符相等
                    dp[i][j] = dp[i - 1][j - 1];
                }else if(s.charAt(j - 1) == '?'){
                    // 是 ？可以匹配任意字符串
                    // 不需要或 dp[i][j - 1] 原因：
                    dp[i][j] = dp[i - 1][j - 1];

                }else if (s.charAt(j - 1) == '*'){
                    // 是 *
                   dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }

}
