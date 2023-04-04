package Year2023.Week.W337;

import java.util.HashMap;
import java.util.Map;

public class q2598 {
    public int findSmallestInteger(int[] nums, int value) {
        // 数组的 MEX 是指其中数组中缺失的最小非负整数
         // nums的最大 MEX

        // 得到连续的值

        // 同余分组
        // 处理取模 ：
        // x mod m = y mod m --> 如果 x < 0 : x mod m + m = y mod m
        // 可以写成 : (x mod m + m) mod m
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int x : nums){
            cnt.merge((x % value + value) % value, 1, Integer::sum);
        }

        int mex = 0;
        while (cnt.merge(mex % value, -1, Integer::sum) >= 0){
            mex ++;
        }

        return mex;
    }
}
