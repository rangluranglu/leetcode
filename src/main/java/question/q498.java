package question;

public class q498 {
    public int[] findDiagonalOrder(int[][] mat) {
        // 主对角线和相等
        int m = mat.length, n = mat[0].length;
        int[] ans = new int[m * n];
        int idx = 0;
        for(int k = 0; k < m + n - 1; k++){
            if(k % 2 == 1){
                // 从上往下
                int i = k < n ? 0 : k - n + 1;
                int j = k < n ? k : n - 1;

                while(i < m && j >= 0){
                    ans[idx] = mat[i][j];
                    idx ++;
                    i ++;
                    j --;
                }
            }else{

                int i = k < m ? k : m - 1;
                int j = k < m ? 0 : k - m + 1;
                while(i >= 0 && j < n){
                    ans[idx] = mat[i][j];
                    idx++;
                    i --;
                    j ++;
                }
            }
        }
        return ans;
    }
}
