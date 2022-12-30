package Year2022.Daily.M11.D14;

import java.util.HashSet;
import java.util.Set;

public class q805 {

    public boolean splitArraySameAverage(int[] nums) {
        // 动态规划
        // 结论 sum(A) / k = sum(nums) / n
        // 等价于 在数组中取k个数，使得 和为 k * avg   0 - 1 背包问题
        // dp[i][x] 为 当前i个元素和为x的可能

        int n = nums.length, m = n / 2;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        boolean flag = false;
        // 判断 提前终止
        for (int i = 1; i <= m; i++) {
            if(sum * i % n == 0){
                flag = true;
                break;
            }
        }

        if(!flag){
            return false;
        }

        Set<Integer>[] dp = new Set[m + 1];
        for (int i = 0; i <= m; i++) {
            dp[i] = new HashSet<>();
        }

        dp[0].add(0);
        for (int num : nums) {
            for (int i = m; i >= 0; i--) {
                for(int x : dp[i - 1]){
                    int cur = x + num;
                    if(cur * n == sum * i){
                        return true;
                    }
                    dp[i].add(cur);
                }
            }
        }

        return false;
    }

    public boolean splitArraySameAverage2(int[] nums) {
        // 折半搜索
        // 结论 sum(A) / k = sum(nums) / n
        if(nums.length == 1){
            return false;
        }

        int n = nums.length, m = n / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * n - sum;
        }

        Set<Integer> left = new HashSet<>();
        for (int i = 1; i < (1 << m); i++) {
            int tot = 0;
            for (int j = 0; j < m; j++) {
                if((i & (1 << j)) != 0){
                    tot += nums[j];
                }
            }

            if(tot == 0){
                return true;
            }
            left.add(tot);
        }

        int rsum = 0;
        for (int i = m; i < n ; i++) {
            rsum += nums[i];
        }

        for (int i = 1; i < (1 << (n - m)); i++){
            int tot = 0;
            for (int j = m; j < n; j++) {
                if((i & (1 << (j - m))) != 0){
                    tot += nums[j];
                }
            }

            if(tot == 0 || (rsum != tot && left.contains(-tot))){
                return true;
            }
        }

        return false;
    }
}
