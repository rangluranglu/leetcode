package Year2022.Week.W319;

public class q2472 {
    public static void main(String[] args) {
        System.out.println(maxPalindromes("fttfjofpnpfydwdwdnns", 3));
    }
    public static int maxPalindromes(String s, int k) {
        // 长度至少为k的字符串
        // 是回文， 重点，不重叠
        // 中心扩展 dp[i] 表示 0 - i-1 中 最大回文子字符串数目
        // s[i] 不在回文串中， dp[i + 1] = dp[i]
        // l .. r 是回文子串
        // dp[r + 1] = max(dp[r+1], dp[l] + 1);
        int n = s.length();
        int[] dp = new int[n + 1];

        for (int i = 0; i < 2 * n - 1 ; i++) {
            // 中心扩展
            // 枚举所有奇数和偶数中心的位置
            int l = i / 2;
            int r = l + i % 2;

            // s[l] 不在回文串中
            dp[l + 1] = Math.max(dp[l + 1], dp[l]);

            for (; l >= 0 && r < n && s.charAt(l) == s.charAt(r); l--, r++){
                if(r - l + 1 >= k){
                    dp[r + 1] = Math.max(dp[r + 1], dp[l] + 1);
                    break;
                }
            }

        }
        return dp[n];
    }
}
