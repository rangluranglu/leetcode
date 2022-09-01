package question;

public class q48 {
    public void rotate(int[][] matrix) {
i
        int n = matrix.length;

        // 按主对角线翻转
        for (int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 按列翻转
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n / 2; j ++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }


    }
}
