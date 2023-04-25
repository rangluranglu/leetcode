package Year2023.Week.W341;

public class q2643 {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] ans = new int[2];
        int m = mat.length, n = mat[0].length;

        for (int i = 0; i < m; i++) {
            int cnt = 0;

            for (int j = 0; j < n; j++) {
                cnt += mat[i][j];
            }

            if(cnt > ans[1]){
                ans[0] = i;
                ans[1] = cnt;
            }
        }

        return ans;
    }
}
