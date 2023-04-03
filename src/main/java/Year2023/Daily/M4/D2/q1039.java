package Year2023.Daily.M4.D2;

import java.util.HashMap;
import java.util.Map;

public class q1039 {
    int n;
    int[] values;
    Map<Integer, Integer> memo = new HashMap<>();
    public int minScoreTriangulation(int[] values) {
        // 多边形 --> n - 2 个 三角形
        // 返回最低分

        // 就两种情况
        // 动态规划 + 记忆化搜索
        this.n = values.length;
        this.values = values;
        return dp(0, n - 1);
    }


    // dp[i][j] j >= i + 2  的值为顶点 i... j 构成的凸 j - i + 1 边进行三角形得到的最低分
    public int dp(int i, int j){
        if(i + 2 > j){
            return 0;
        }

        if(i + 2 == j){
            // 是三角形
            return values[i] * values[i + 1] * values[j];
        }

        int key = i * n + j;
        if(!memo.containsKey(key)){
            int minScore = Integer.MAX_VALUE;
            for(int k = i + 1; k < j; k++){
                minScore = Math.min(minScore, values[i] * values[k] * values[j] + dp(i, k) + dp(k, j));
            }
            memo.put(key, minScore);
        }

        return memo.get(key);
    }
}
