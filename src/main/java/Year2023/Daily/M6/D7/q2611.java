package Year2023.Daily.M6.D7;

import java.util.Arrays;

public class q2611 {

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        // 第一只老鼠吃掉 reward1， 第二只老鼠吃掉 reward2
        // 第一只恰好k个，最大得分
        // 贪心 , 第一只k， 第二只 n - k
        // 使用diff数组记录差值

        int n = reward1.length;
        int ans = 0;
        int[] diffs = new int[n];

        for (int i = 0; i < n; i++) {
            diffs[i] = reward1[i] - reward2[i];
            ans += reward2[i];
        }

        Arrays.sort(diffs);

        for (int i = 1; i <= k; i++) {

            ans += diffs[n - i];
        }

        return ans;

    }
}
