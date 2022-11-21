package WeekCompetition.year2022.W318;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class q2463 {
    long[][] f;
    long inf = (long) 1e13;
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        // 找到最小的差值
        // 记忆化搜索
        // 邻项交换法
        // 排序之后， 每个工厂修复的机器人是连续的
        // 枚举 第i个工厂修了k个机器人
        // f(i, j) = min f(i + 1, j +k) + cost(i, j, k)

        int m = robot.size(), n = factory.length;

        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
        Collections.sort(robot);

        f = new long[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], inf);
        }

        return dfs(0, 0, robot, factory);
    }

    // i 工厂坐标
    // j 机器人坐标
    public long dfs(int i, int j, List<Integer> robot, int[][] factory){
        // 记忆化搜索

        int m = robot.size();
        int n = factory.length;

        if(j == m){
            // 所有机器人匹配完毕
            return 0;
        }

        if(i == n - 1){
            // 最后一个工厂

            // 机器人数量大于工厂能处理数量
            if(factory[i][1] < m - j){
                return inf;
            }

            // 计算距离
            long ans = 0;
            for (int k = j; k < m; k++) {
                ans += Math.abs(robot.get(k) - factory[i][0]);
            }

            f[i][j] = ans;
            return ans;
        }

        // 当前状态已经计算过
        if(f[i][j] != inf){
            return f[i][j];
        }

        // 当前工厂不处理任何球
        long ans = dfs(i + 1, j, robot, factory);

        long dis = 0;
        for(int k = j; k < Math.min(m, j + factory[i][1]); k ++){
            dis += Math.abs(robot.get(k) - factory[i][0]);

            long c = dfs(i + 1, k +1, robot, factory);
            ans = Math.min(ans, c + dis);
        }

        f[i][j] = ans;

        return ans;
    }


    public long minimumTotalDistance2(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        int n = robot.size();
        int m = factory.length;

        long[][] dp = new long[m + 1][n + 1]; // 前i个工厂修前j个机器人的最少移动距离

        for(long[] e : dp){
            Arrays.fill(e, inf);
        }

        dp[0][0] = 0;

        for (int i = 1; i <= m; i++) {
            dp[i][0] = 0;
            for (int j = 1; j <= n; j++) {
                // i个工厂， j个机器人
                dp[i][j] = dp[i - 1][j];
                long sum = 0;
                for(int k = 1; k <= Math.min(j, factory[i - 1][1]); k ++){
                    // 本工厂可以 修理的机器人个数
                    sum += Math.abs(robot.get(j - k) - factory[i - 1][0]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k] + sum);
                }
            }
        }

        return dp[m][n];


    }



}
