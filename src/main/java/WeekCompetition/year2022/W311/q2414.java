package WeekCompetition.year2022.W311;

import java.util.Arrays;

public class q6181 {
    public int longestContinuousSubstring(String s) {
        int n = s.length();
        if(n == 1){
            return n;
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if(s.charAt(i) - s.charAt(i - 1) == 1){
                dp[i] = dp[i - 1] + 1;
                ans = Math.max(ans, dp[i]);
            }
        }

        return ans;
    }
}
