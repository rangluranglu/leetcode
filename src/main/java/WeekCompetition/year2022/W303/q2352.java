package WeekCompetition.year2022.W303;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q2352 {
    public int equalPairs(int[][] grid) {
        int  n = grid.length;
        Map<Integer, List<Integer>> indexMap = new HashMap<>();


        for(int i = 0; i < n; i++){
            indexMap.computeIfAbsent(grid[0][i], x -> new ArrayList<Integer>()).add(i);
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(indexMap.containsKey(grid[i][0])){
                // 对比
                for(int j : indexMap.get(grid[i][0])){
                    if(help(grid, i, j)){
                        ans ++;
                    }
                }
            }
        }

        return ans;
    }
    public boolean help(int[][] grid, int i, int j){
        for(int index = 0; index < grid.length; index ++){
            if(grid[i][index] != grid[index][j]){
                return false;
            }
        }

        return true;
    }
}
