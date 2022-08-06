package question;

public class interview0107 {
    public void rotate(int[][] matrix) {
        // 先上下反转，沿主对角线反转、
        int n = matrix.length;

        for(int i = 0; i < n/2; i++){
            for (int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1- i][j] = tmp;
            }
        }

        for(int i = 0; i < n; i ++){
            for(int j = 0; j < i; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
