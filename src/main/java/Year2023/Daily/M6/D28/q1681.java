package Year2023.Daily.M6.D28;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class q1681 {
    public int minimumIncompatibility(int[] nums, int k) {
        // 数组分到k个相同大小的子集中，同一个子集没有相同的两个元素
        // 不兼容性 是最大值和最小值的差
        // 不兼容性的和的最小值

        int n = nums.length, group = n / k, inf = Integer.MAX_VALUE;
        int[] dp = new int[1 << n];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        HashMap<Integer, Integer> values = new HashMap<>();

        for(int mask = 1; mask < (1 << n); mask ++){
            // 枚举状态,不足一组
            if(Integer.bitCount(mask) != group){
                continue;
            }

            int mn = 20, mx = 0;
            HashSet<Integer> cur = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if((mask & (1 << i)) > 0){
                    // 选中i
                    if(cur.contains(nums[i])){
                        break;
                    }

                    cur.add(nums[i]);
                    mn = Math.min(mn, nums[i]);
                    mx = Math.max(mx, nums[i]);
                }
            }

            if(cur.size() == group){
                values.put(mask, mx - mn);
            }
        }

        for(int mask = 0; mask < (1 << n); mask++){
            if(dp[mask] == inf){
                continue;
            }

            HashMap<Integer, Integer> seen = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if((mask & (1 << i)) == 0){
                    seen.put(nums[i], i);
                }
            }

            if(seen.size() < group){
                continue;
            }

            int sub = 0;
            for(int v : seen.values()){
                sub |= (1 << v);
            }

            int nxt = sub;
            // 枚举子集
            while (nxt > 0){
                if(values.containsKey(nxt)){
                    dp[mask | nxt] = Math.min(dp[mask | nxt], dp[mask] + values.get(nxt));
                }
                nxt = (nxt - 1) & sub;
            }
        }

        return dp[(1 << n) - 1] < inf ? dp[(1 << n) - 1] : -1;
    }
}
