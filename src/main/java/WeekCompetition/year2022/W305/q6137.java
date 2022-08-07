package WeekCompetition.year2022.W305;

import java.util.Arrays;

public class q6137 {

    public static void main(String[] args) {
        int[] nums = {579611,579611,579611,731172,731172,496074,496074,496074,151416,151416,151416};
        System.out.println(validPartition(nums));
    }
    public static boolean validPartition(int[] nums) {
        int n = nums.length;
        // 贪心， 逆序
        if(n == 2){
            return nums[0] == nums[1];
        }
        boolean[] dp = new boolean[n];
        dp[0] = false;
        // 初 始化
        if(nums[0] == nums[1]){
            dp[1] = true;
            if(nums[2] == nums[1]){
                dp[2] = true;
            }
        }else if(nums[1] - nums[0] == 1 && nums[2] - nums[1] == 1){
            dp[2] = true;
        }else {
            return false;
        }

        for(int i = 3; i < n; i++){
            dp[i] = (nums[i] == nums[i- 1] && dp[i - 2]) || (nums[i] - nums[i - 1] == 1 && nums[i - 1] - nums[i - 2] == 1 && dp[i - 3])
            || (nums[i] == nums[i - 1] && nums[i - 1] == nums[i- 2] && dp[i - 3]);
        }

        System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }
}
