package Year2023.Daily.M6.D6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q2352 {
    public int equalPairs(int[][] grid) {
        // 相同行列对， 构造key ? List<Integer>

        int n  = grid.length;
        Map<List<Integer>, Integer> cnt = new HashMap<>();
        for(int[] row : grid){
            List<Integer> arr = new ArrayList<>();
            for(int num : row){
                arr.add(num);
            }

            cnt.put(arr, cnt.getOrDefault(arr, 0) + 1);
        }


        int ans = 0;
        // 遍历列
        for(int j = 0; j < n; j ++){
            List<Integer> arr = new ArrayList<>();
            for(int i =  0; i < n; i++){
                arr.add(grid[i][j]);
            }

            if(cnt.containsKey(arr)){
                ans += cnt.get(arr);
            }
        }

        return ans;


    }
}
