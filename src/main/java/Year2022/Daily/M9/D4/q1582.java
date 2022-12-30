package Year2022.Daily.M9.D4;

public class q1582 {
    public int numSpecial(int[][] mat) {
        //
        int m = mat.length, n = mat[0].length;
        int[] row = new int[m];
        int[] col = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i] += mat[i][j];
                col[j] += mat[i][j];
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j] == 1 && row[i] == 1 && col[j] == 1){
                    ans ++;
                }
            }
        }

        return ans;
    }

    public int numSpecial2(int[][] mat){
        // 原地列标记
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            int cnt1 = 0;
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1){
                    cnt1 ++;
                }
            }

            if(i == 0){
                cnt1 --;
            }
            if(cnt1 > 0){
                for (int j = 0; j < n; j++) {
                    if(mat[i][j] == 1){
                        mat[0][j] += cnt1;
                    }
                }
            }
        }
        int sum = 0;
        for (int num : mat[0]) {
            if (num == 1) {
                sum++;
            }
        }
        return sum;
    }
}
