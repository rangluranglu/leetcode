package Year2023.Week.W350;

import java.util.Arrays;

public class q2742 {
    public int paintWalls(int[] cost, int[] time) {
        // 0-1 背包
        // 付费 + 免费 = n， 付费刷墙时间只和 >= 免费刷墙个数， 付费刷墙时间 >= n - 付费刷墙个数
        // [付费刷墙时间 + 1] 之和 >= n
        int n = cost.length;

        int[] f = new int[n + 1];
        Arrays.fill(f, Integer.MAX_VALUE / 2);

        f[0] = 0;

        for (int i = 0; i < n; i++) {
            int c = cost[i], t = time[i] + 1;
            for (int j = n; j > 0; j--) {
                f[j] = Math.min(f[j], f[Math.max(j - t, 0)] + c);
            }
        }

        return f[n];
        // time[i] + 看成物品体积， cost[i] 看成物品价值

    }
}
