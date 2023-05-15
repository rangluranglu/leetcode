package Year2023.Daily.M5.D15;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class q1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        // 列翻转， 的所有值相等，的最大行数
        // 哈希，如何两行翻转相同列得到相同结果，那么这两行本质相同

        int m = matrix.length, n = matrix[0].length;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            char[] arr = new char[n];
            Arrays.fill(arr, '0');

            for (int j = 0; j < n; j++) {
                arr[j] = (char) ('a' + (matrix[i][j] ^ matrix[i][0]));
            }

            String s = new String(arr);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int ans = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            ans = Math.max(entry.getValue(), ans);
        }

        return ans;


    }
}
