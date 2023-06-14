package Year2023.Daily.M6.D14;

public class q1375 {
    public int numTimesAllBlue(int[] flips) {
        // 是否前缀出现过
        // 如何快速判断是否出现， 出现几次, 什么数据结构合适？？

        // 维护最大值, 前提 构成排列
        int ans = 0, mx = 0, n = flips.length;
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, flips[i]);

            if(mx == i + 1){
                ans ++;
            }
        }

        return ans;

    }
}
