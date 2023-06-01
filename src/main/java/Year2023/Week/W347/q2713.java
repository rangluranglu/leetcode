package Year2023.Week.W347;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class q2713 {
    public int maxIncreasingCells(int[][] mat) {
        // 动态规划
        TreeMap<Integer, List<int[]>> g = new TreeMap<Integer, List<int[]>>();
        int m = mat.length, n = mat[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++ ){
                // 相同元素放在同一组
                g.computeIfAbsent(mat[i][j], k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        int ans = 0;
        // 维护最大值
        int[] rowMax = new int[m], colMax = new int[n];

        for(List<int[]> pos : g.values()){
            int[] mx = new int[pos.size()];

            // 算出最大值
            for (int i = 0; i < pos.size(); i++) {
                mx[i] = Math.max(rowMax[pos.get(i)[0]], colMax[pos.get(i)[1]]) + 1;
                ans = Math.max(ans, mx[i]);
            }

            for(int k = 0; k < pos.size(); k++){
                int i = pos.get(k)[0], j = pos.get(k)[1];
                rowMax[i] = Math.max(rowMax[i], mx[k]);
                colMax[j] = Math.max(colMax[j], mx[k]);
            }
        }

        return ans;
    }
}
