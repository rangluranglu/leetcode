package question;

public class q1292 {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int[][] preSum = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++){
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        int r = Math.min(m, n);
        int ans = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 枚举，定位左上点，枚举边长
                for(int k = ans + 1; k <= r; k ++){
                    if(i - 1 + k <= m && j - 1 + k <= n){
                        //计算和
                        int sum = preSum[i - 1 + k][j - 1 + k] - preSum[i - 1][j - 1 + k] - preSum[i - 1 + k][j - 1] + preSum[i - 1][j - 1];
                        if(sum <= threshold){
                            ans = k;
                        }else {
                            break;
                        }

                    }else {
                        break;
                    }
                }
            }
        }

        return ans;

    }
}
