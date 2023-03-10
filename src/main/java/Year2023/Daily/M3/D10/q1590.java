package Year2023.Daily.M3.D10;

import java.util.HashMap;
import java.util.Map;

public class q1590 {
    public int minSubarray(int[] nums, int p) {
        // 移除 最短子数组 使剩余元素和 能被p整除  --> 子数组连续
        // 前缀和
        // 同余 ： (x - y) mod p == 0; 则称 x 与 y 对模 p 同余
        // 在前缀和数组上找到两个数 s[left] 和 s[right] 满足 right - left 最小且 s[right] - s[left] = x (mode p);

        int n = nums.length, ans = n;
        int[] preSum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            preSum[i] = (preSum[i - 1] + nums[i - 1]) % p;
        }

        int x = preSum[n];
        if(x == 0){
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            map.put(preSum[i], i);

            // 如果不存在, -n 可以保证 i - j >= n
            int j = map.getOrDefault((preSum[i] - x +p) % p, -n);
            ans = Math.min(ans, i - j);
        }

        return ans < n ? ans : -1;

    }
}
