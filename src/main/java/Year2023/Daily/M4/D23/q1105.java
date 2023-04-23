package Year2023.Daily.M4.D23;

import java.util.Arrays;

public class q1105 {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        // 最小高度

        // 动态规划

        // dp[i] 第i本书的最小高度
        int n = books.length;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;


        for (int i = 0; i < n; i++) {
            int maxHeight = 0, curWidth = 0;

            for(int j = i; j >= 0; j--){
                curWidth += books[j][0];
                if(curWidth > shelfWidth){
                    break;
                }

                maxHeight = Math.max(maxHeight, books[j][1]);
                dp[i + 1] = Math.min(dp[i + 1], dp[j] + maxHeight);
            }
        }

        return dp[n];

    }
}
