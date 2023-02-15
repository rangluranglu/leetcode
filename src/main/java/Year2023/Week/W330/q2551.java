package Year2023.Week.W330;

import java.util.Arrays;

public class q2551 {
    public long putMarbles(int[] weights, int k) {
        // 最大分数 - 最小分数
        // weight 分为 K 组
        // weight[0] 和 weight[n - 1] 一定在分数中
        // 上一个子数组的末尾和下一个子数组的开头一定同时在分数中。
        // n - 1 个 weight[i] + weight[i + 1] 算出来，排序， 最大的 k - 1 - 最小的k - 1


         int n = weights.length;
        for (int i = 0; i < n - 1; i++) {
            weights[i] += weights[i + 1];
        }
        long ans = 0;
        Arrays.sort(weights, 0, n - 1);
        for (int i = 0; i < k - 1; i++) {
            ans += (weights[n - 2 - i] - weights[i]);
        }
        return ans;
    }
}
