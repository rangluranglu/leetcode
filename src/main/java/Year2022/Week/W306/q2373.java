package Year2022.Week.W306;

public class q2373 {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        if (n <= 2){
            return new int[0][0];
        }
        int[][] ans = new int[n - 2][n - 2];

        for(int i = 0; i < n - 2; i++){
            for(int j = 0; j < n - 2; j++){
                // 中心 i + 1, j + 1;
                int max = 0;
                for(int x = i; x <= i + 2; x ++){
                    for(int y = j; y <= j + 2; y++){
                        max = Math.max(grid[x][y], max);
                    }
                }

                ans[i][j] = max;

            }
        }

        return ans;
    }
}
