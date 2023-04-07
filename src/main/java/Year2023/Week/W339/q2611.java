package Year2023.Week.W339;

import java.util.Arrays;

public class q2611 {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {

        // 第一只吃掉k个
        // 动态规划
        // r1[i] + r2[j] > r2[i] + r1[j] --> r1[i] - r2[i] > r1[j] - r2[j]

        int ans = 0, n = reward1.length;

        for (int i = 0; i < n; i++) {
            // 全部给第二只老鼠
            ans += reward2[i];
            reward1[i] -= reward2[i];
        }

        // 递增
        Arrays.sort(reward1);

        for(int i = n - k; i < n; i++){
            ans += reward1[i];
        }

        return ans;
    }
}
