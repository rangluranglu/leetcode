package Year2023.Daily.M6.D20;

import java.util.Arrays;
import java.util.List;

public class q1595 {
    public int connectTwoGroups(List<List<Integer>> cost) {
        // size1 >= size2
        // 如果两个组中的每个点都与另一组中的一个或多个点连接，则称这两组点是连通的。

        int size1 = cost.size(), size2 = cost.get(0).size();
        int m = 1 << size2 ;
        // 状态压缩dp
        // dp[i][s] 表示第一组前i个点与第二组的点集s的连通成本(size1 >= size2)

        int[][] dp = new int[size1 + 1][m];
        for (int i = 0; i <= size1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }

        // 初始化
        dp[0][0] = 0;

        for (int i = 1; i <= size1; i++) {
            for(int s = 0; s < m; s++){
                for(int k = 0; k < size2; k++){
                    if((s & (1 << k)) == 0){
                        // 不在集合中
                        continue;
                    }

                    // 除去第k个点， s的第k个点不在与其他点连接
                    dp[i][s] = Math.min(dp[i][s], dp[i][s ^ (1 << k)] + cost.get(i - 1).get(k));
                    // 第一组前 i−1 个点不再与其他点连接
                    dp[i][s] = Math.min(dp[i][s], dp[i - 1][s] + cost.get(i - 1).get(k));
                    // 第一组前 i− 个点和第二组点集 s 的第 k 个点都不再与其他点连接
                    dp[i][s] = Math.min(dp[i][s], dp[i - 1][s ^ (1 << k)] + cost.get(i - 1).get(k));
                }
            }
        }
        return dp[size1][m - 1];
    }
}
