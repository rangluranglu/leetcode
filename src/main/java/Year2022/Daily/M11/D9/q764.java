package Year2022.Daily.M11.D9;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class q764 {

    public static void main(String[] args) {
        int[][] ans = new int[][]{{3, 0}, {3, 3}};
        System.out.println(orderOfLargestPlusSign(5, ans));
    }
    public static int orderOfLargestPlusSign(int n, int[][] mines) {
        Set<Integer> set = new HashSet<>();
        for (int[] mine : mines){
            set.add(mine[0] * n + mine[1]);
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], n);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++){
                if(set.contains(i * n + j)){
                    count = 0;
                }else {
                    count ++;
                }
                dp[i][j] = Math.min(dp[i][j], count);
            }

            count = 0;
            for (int j = n - 1; j >= 0 ; j--) {
                if(set.contains(i * n + j)){
                    count = 0;
                }else {
                    count ++;
                }
                dp[i][j] = Math.min(dp[i][j], count);
            }
        }

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (set.contains(j * n + i)){
                    count = 0;
                }else {
                    count ++;
                }
                dp[j][i] = Math.min(dp[j][i], count);
            }
            count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (set.contains(j * n + i)){
                    count = 0;
                }else {
                    count ++;
                }
                dp[j][i] = Math.min(dp[j][i], count);
                ans = Math.max(ans, dp[j][i]);
            }
        }


        return ans;
    }
}
