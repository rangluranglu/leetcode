package Year2023.Daily.M3.D14;

public class q1605 {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length, m = colSum.length;

        // 模拟
        int[][] matrix = new int[n][m];

        int i = 0, j = 0;

        while (i < n && j < m){
            int v = Math.min(rowSum[i], colSum[j]);
            matrix[i][j] = v;

            rowSum[i] -= v;
            colSum[j] -= v;

            if(rowSum[i] == 0){
                i ++;
            }

            if(colSum[j] == 0){
                j ++;
            }
        }

        return matrix;

    }
}
