package Year2023.Week.W333;

public class q2573 {
    public String findTheString(int[][] lcp) {
        // lcp[i][j] 等于 word[i,...n-1] 和 word[j,...,n-1] 的最长公共前缀的长度

        // 模拟

        int n = lcp.length;
        int i = 0;
        char[] s = new char[n];

        for(char c = 'a'; c <= 'z'; c++){
            while (i < n && s[i] > 0){
                i++;
            }

            if(i == n) break;

            for(int j = i; j < n; j++){
                if(lcp[i][j] > 0){
                    s[j] = c;
                }
            }
        }

        while (i < n){
            if(s[i++] == 0){
                // 没有构造完
                return "";
            }
        }


        for(i = n - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                int actualLCP = s[i] != s[j] ? 0 : i == n - 1 || j == n - 1 ? 1 : lcp[i + 1][j + 1] + 1;
                if(lcp[i][j] != actualLCP){
                    return "";
                }
            }
        }

        return new String(s);
    }
}
