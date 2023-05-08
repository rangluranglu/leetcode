package Year2023.Week.DW97;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class q2555 {
    public int maximizeWin(int[] prizePositions, int k) {
        // 双指针， 强制让第二条线段的右端点落在奖品上， 需要知道在prizePositions[left] 左侧的第一条线段最多覆盖多少个奖品。
        // pre[right + 1] 记录线段右端点不超过prizePositions[right] 时最多可以覆盖多少个奖品。下标错开一位是为了方便下面计算。

        // pre[right + 1] = max(pre[right], left - right + 1)

        int ans = 0, left = 0, n = prizePositions.length;

        int[] pre = new int[n + 1];

        for (int right = 0; right < n; right ++){
            while(prizePositions[right] - prizePositions[left] > k){
                left ++;
            }

            ans = Math.max(ans, right - left + 1 + pre[left]);

            pre[right + 1] = Math.max(pre[right], right - left + 1);
        }

        return ans;


    }
}
