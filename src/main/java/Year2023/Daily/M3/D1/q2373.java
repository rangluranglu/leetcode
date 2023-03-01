package Year2023.Daily.M3.D1;

public class q2373 {
    public int[][] largestLocal(int[][] grid) {
        // n < 100 可以暴力
        int n = grid.length;

        int[][] ans = new int[n - 2][n - 2];


        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                for(int x = i; x < i+3; x++){
                    for(int y = j; y < j + 3; y++){
                        ans[i][j] = Math.max(ans[i][j], grid[x][y]);
                    }
                }
            }
        }

        return ans;


        // 思考 如果很大的矩阵 m*n 怎么计算？  使用二维单调队列

    }
}
