package WeekCompetition.year2022.W313;

public class q2430 {
    public int deleteString(String s) {
        // 树状DP
        // f[i] 表示删除后缀 s[i: ] 的最大操作数
        // 如果 s[i : i + j] == s[i + j : i+2j] 那么就可以删除
        // 转移方程： f[i] = f[i + j] + 1
        char[] chars = s.toCharArray();
        int n = chars.length;

        if (allEquals(chars)) {
            return n;
        }

        int[][] lcp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i++) {
            for (int j = n - 1; j < i; j++) {
                if(s.charAt(i) == s.charAt(j)){
                    lcp[i][j] = lcp[i + 1][j + 1] + 1;
                }
            }
        }

        int[] f = new int[n];
        for (int i = n - 1; i >= 0; i--){
            for(int j = 1; i + j * 2 <= n; j ++){
                if(lcp[i][i + j] >= j){
                    f[i] = Math.max(f[i], f[i + 1]);
                }
            }
            f[i]++;
        }

        return f[0];
    }

    private boolean allEquals(char[] s){
        for (int i = 0; i < s.length; i++) {
            if(s[i] != s[0]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}