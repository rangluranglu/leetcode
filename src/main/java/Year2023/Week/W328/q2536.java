package Year2023.Week.W328;

import java.util.Arrays;

public class q2536 {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        // 二维差分

        int[][] d = new int[n + 1][n + 1], ans = new int[n][n];

        // 构造差分数组
        for(int[] q : queries){
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];

            d[r1][c1] ++;
            d[r1][c2 + 1] --;
            d[r2 + 1][c1] --;
            d[r2 + 1][c2 + 1] ++;
        }
        System.out.println(Arrays.deepToString(d));
        // 使用前缀和复原
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++){
                // 还原数组
                if(i == 0 && j == 0){
                    ans[i][j] = d[i][j];
                } else if(i == 0){
                    ans[i][j] = d[i][j] += d[i][j - 1];
                }else if (j == 0){
                    ans[i][j] = d[i][j] += d[i - 1][j];
                }else {
                    ans[i][j] = d[i][j] += d[i][j - 1] + d[i - 1][j] - d[i-1][j-1];
                }


            }
        }
        // 另一种计算方法：
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                d[i][j] += d[i][j - 1];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] += d[i - 1][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = d[i][j];
            }
        }

        // 还可以令d 的长度位 n + 2, 在前面增加一列，可以避免复杂的下标转换

        return ans;




    }
}
