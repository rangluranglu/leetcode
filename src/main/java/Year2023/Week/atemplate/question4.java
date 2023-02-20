package Year2023.Week.atemplate;

public class question4 {

    public String findTheString(int[][] lcp) {
        // 返回lcp 字典序最小
        // 构造
        // s[0] 一定可以填入a吗
        // 根据lcp[0] 还有哪些s[i] 一定是 a， 哪些一定不是a
        // lcp[0][i] > 0 的一定是a, lcp[0][i]=0 的一定不是a

        int i = 0, n = lcp.length;
        char[] s = new char[n];

        for(char c = 'a'; c <= 'z'; c++){
            while (i < n && s[i] > 0){
                // 已经被填充
                i++;
            }

            if(i == n){
                // 构造完毕
                break;
            }

            for(int j = i; j < n; j++){
                if(lcp[i][j] >0){
                    s[j] = c;
                }
            }
        }

        while (i < n){
            if(s[i ++] == 0){
                // 没有构造完
                return "";
            }
        }

        for(i = n - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                int actualLCP = s[i] != s[j] ? 0 : 1 == n-1 || j == n-1 ? 1 : lcp[i + 1][j + 1] + 1;
                if(lcp[i][j] != actualLCP){
                    return "";
                }
            }
        }

        return new String(s);
    }
}
