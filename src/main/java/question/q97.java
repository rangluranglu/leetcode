package question;

public class q97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        // 递归超时
        int i = 0, j = 0;

        while(i < s1.length() && j < s2.length()){
            int index = i + j;
            if(s1.charAt(i) == s3.charAt(index) && s2.charAt(j) == s3.charAt(index)){
                return isInterleave(s1.substring(i), s2.substring(j + 1), s3.substring(index + 1)) ||
                        isInterleave(s1.substring(i + 1), s2.substring(j), s3.substring(index + 1));
            }else if(s1.charAt(i) == s3.charAt(index)){
                i ++;
            }else if(s2.charAt(j) == s3.charAt(index)){
                j ++;
            }else {
                return false;
            }
        }

        if(i < s1.length()){
            return s1.substring(i).equals(s3.substring(i + j));
        }

        if(j < s2.length()){
            return s2.substring(j).equals(s3.substring(i + j));
        }

        return true;
    }

    public boolean isInterleave2(String s1, String s2, String s3) {
        // 动态规划
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }

        int m = s1.length(), n = s2.length();
        // 前i个s1 和 前j个s2 是否 和 s3的i+j个相等
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                int k = i + j - 1;
                if(i > 0){
                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(k));
                }
                if(j > 0){
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(k));
                }
            }
        }

        return dp[m][n];
    }

}
