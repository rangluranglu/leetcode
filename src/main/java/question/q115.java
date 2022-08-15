package question;

public class q115 {
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";

        System.out.println(numDistinct2(s, t));
    }
    static int ans, m, n;
    public static int numDistinct(String s, String t) {
        ans = 0;
        m = s.length();
        n = t.length();

        if(t.length() > s.length()){
            return 0;
        }

        if(t.length() == s.length()){
            return t.equals(s) ? 1 : 0;
        }


        dfs(s, t, new StringBuilder(), 0);
        return ans;
    }


    public static void dfs(String s, String t, StringBuilder path, int index){
        if(path.length() == n || index == m){
            if(path.toString().equals(t)){
                ans ++;
            }
            return;
        }

        // 不加入当前元素
        dfs(s, t, path, index + 1);

        if(s.charAt(index) == t.charAt(path.length())){
            dfs(s, t, path.append(s.charAt(index)), index+1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    // dfs 会超时， 记忆化搜索可能有效， 接下来尝试 dp

    public static int numDistinct2(String s, String t) {
        ans = 0;
        int m = s.length();
        int n = t.length();

        if(n > m){
            return 0;
        }
        if(t.length() == s.length()){
            return t.equals(s) ? 1 : 0;
        }
        // 表示 s[i] 的子序列中 t[j] 的出现次数；
        int[][] dp = new int[m + 1][n + 1];
        // 初始化, j = 0 表示 t是空串，任何字符都包含空串。
        for(int i = 0; i <= m ;i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    // 如果字符相等，还要看 s[i] 的前一个字符是否匹配
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];

    }
}
