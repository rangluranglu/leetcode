package WeekCompetition.year2022.W323;

import java.util.*;

public class q2501 {
    public int longestSquareStreak(int[] nums) {
        // 排序
        Arrays.sort(nums);
        int n = nums.length;

        // dp
        int[] dp = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        Arrays.fill(dp, 1);

        int ans = -1;
        for(int i = 0; i < n; i++){
           int x = (int) Math.sqrt(nums[i]);
           // 查找
            if(x * x != nums[i]){
                continue;
            }
            // 找到
            if(map.containsKey(x)){
                dp[i] = dp[map.get(x)] + 1;
                ans = Math.max(ans, dp[i]);
            }
        }

        return ans;


    }

    // 记忆化搜索
    Set<Long> set = new HashSet<>();
    public int longestSquareStreak2(int[] nums) {
        for (int num : nums) {
            set.add((long) num);
        }

        int ans = -1;

        for(Long x : set){
            ans = Math.max(ans, dfs(x));
        }

        return ans > 1 ? ans : -1;

    }
    // 排序

    public int dfs(long x){
        if(!set.contains(x)){
            return 0;
        }

        return 1 + dfs(x * x);
    }
}
