package Year2023.Week.W348;

import java.util.HashSet;
import java.util.Set;

public class q2718 {
    public long matrixSumQueries(int n, int[][] queries) {
        // type = 0， 行
        // type = 1, 列
        // 返回和
        // 倒序操作

        long ans = 0;
        Set<Integer>[] vis = new Set[]{new HashSet(), new HashSet()};

        for (int i = queries.length - 1; i >= 0; i--) {
            int[] q = queries[i];

            int type = q[0], index = q[1], val = q[2];
            if(!vis[type].contains(index)){
                // 没有操作

                ans += (long) (n - vis[type ^ 1].size() ) * val;
                vis[type].add(index);
            }

        }
        return ans;
    }
}
