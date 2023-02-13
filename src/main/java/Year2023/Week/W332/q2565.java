package Year2023.Week.W332;

public class q2565 {
    public int minimumScore(String s, String t) {
        // t --> s的子序列 最小得分

        // 分别计算 t的前后缀 是不是子序列
        char[] S = s.toCharArray(), T = t.toCharArray();
        int n = S.length, m = T.length;

        // 后缀
        int[] suf = new int[n + 1];
        suf[n] = m;

        for(int i = n - 1, j = m - 1; i >= 0; i--){
            if(j >= 0 && S[i] == T[j]){
                j --;
            }

            // 后缀下标
            suf[i] = j + 1;
        }

        int ans = suf[0];
        if(ans == 0){
            return 0;
        }

        for(int i = 0, j = 0; i < n; i++){
            if(S[i] == T[j]){
                ans = Math.min(ans, suf[i + 1] - ++j);
            }
        }

        return ans;
    }
}
