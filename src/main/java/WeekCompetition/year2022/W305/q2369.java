package WeekCompetition.year2022.W305;

public class q2369 {
    public static void main(String[] args) {
        String a = "abad";
        System.out.println(longestIdealString(a, 0));
    }
    public static int longestIdealString(String s, int k) {
        int n = s.length();
        int ans = 1;
        int[] dp = new int[n];
        int[] count = new int[26];

        dp[0] = 1;
        count[s.charAt(0) - 'a'] ++;

        for (int i = 1; i < n; i++) {
            char ch = s.charAt(i);
            dp[i] = 1;
            for(int j = Math.max(ch - k - 'a', 0); j <= Math.min(ch + k - 'a', 25); j++){
                if(count[j] + 1 > dp[i]){
                    dp[i] = count[j] + 1;
                    ans = Math.max(dp[i], ans);
                }
            }

            count[ch - 'a'] = Math.max(dp[i], count[ch - 'a']);
        }

        return ans;
    }
}
