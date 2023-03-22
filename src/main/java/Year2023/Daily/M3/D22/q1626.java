package Year2023.Daily.M3.D22;

import java.util.Arrays;

public class q1626 {
    public int bestTeamScore(int[] scores, int[] ages) {
        // 动态规划
        // 按照分数升序， 分数相同 年龄升序
        // dp 设dp[i] 为我们最后组建的球队中的最大球员序号为排序后的第 i 名球员时的球队最大分数

        int n = scores.length;
        int[][] people = new int[n][2];

        for (int i = 0; i < n; i++) {
            people[i] = new int[]{scores[i], ages[i]};
        }

        Arrays.sort(people, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int[] dp = new int[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--){
                if(people[j][1] <= people[i][1]){
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }

            dp[i] += people[i][0];
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
