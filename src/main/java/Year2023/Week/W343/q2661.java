package Year2023.Week.W343;

public class q2661 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length;

        int[][] indexMap = new int[m * n + 1][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                indexMap[mat[i][j]][0] = i;
                indexMap[mat[i][j]][1] = j;
            }
        }

        int[] row_cnt = new int[m];
        int[] col_cnt = new int[n];

        for (int i = 0; i < arr.length; i++) {
            row_cnt[indexMap[arr[i]][0]]++;
            col_cnt[indexMap[arr[i]][1]]++;

            if(row_cnt[indexMap[arr[i]][0]] == n || col_cnt[indexMap[arr[i]][1]] == m){
                return i;
            }
        }

        return -1;
    }
}
