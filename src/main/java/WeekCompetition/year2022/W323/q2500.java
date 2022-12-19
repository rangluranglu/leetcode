package WeekCompetition.year2022.W323;

import java.util.Arrays;

public class q2500 {
    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        for(int[] g : grid){
            Arrays.sort(g);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < m; j++) {
                max = Math.max(grid[j][i], max);
            }
            ans += max;
        }

        return ans;
    }
}
