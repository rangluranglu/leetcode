package Year2023.Week.W329;

import java.util.Arrays;

public class q2545 {
    public int[][] sortTheStudents(int[][] score, int k) {
        int m = score.length;
        int n = score[0].length;

        Integer[] index = new Integer[m];

        for (int i = 0; i < m; i++) {
            index[i] = i;
        }

        Arrays.sort(index, (i, j) -> score[j][k] - score[i][k]);

        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++){
                ans[i][j] = score[index[i]][j];
            }
        }

        return ans;
    }
}
