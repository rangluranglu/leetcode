package Daily.year2022.M12.D10;

import java.util.Arrays;

public class q1691 {
    public int maxHeight(int[][] cuboids) {
        // 动态规划


        int  n = cuboids.length;
        for(int[] v : cuboids){
            Arrays.sort(v);
        }
        Arrays.sort(cuboids, (a, b) -> (a[0] + a[1] + a[2]) - (b[0] + b[1] + b[2]));
        int ans = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = cuboids[i][2];
            for (int j = 0; j < i; j++) {
                if (cuboids[i][0] >= cuboids[j][0] &&
                        cuboids[i][1] >= cuboids[j][1] &&
                        cuboids[i][2] >= cuboids[j][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;

    }
}
