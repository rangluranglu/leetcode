package Year2022.Daily.M9.D30;

public class interview0108 {
    public void setZeroes(int[][] matrix) {
        // 标记
        int m = matrix.length;
        int n = matrix[0].length;
        int flagCol0 = 1, flagRow0 = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // 行是0
                    if (i == 0) {
                        flagCol0 = 0;
                    }
                    // 列是0
                    if (j == 0) {
                        flagRow0 = 0;
                    }
                    if(i != 0 && j != 0) {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }

                }
            }
        }
        //System.out.println(flagCol0);
        //System.out.println(flagRow0);
        for (int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(flagCol0 == 0){
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

        if(flagRow0 == 0){
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
