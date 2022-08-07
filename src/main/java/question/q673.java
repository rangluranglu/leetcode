package question;

import java.util.Arrays;

public class q673 {
    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};

        System.out.println(findNumberOfLIS1(nums));
    }
    public static int findNumberOfLIS1(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1, count = 1;
        int[] cnt = new int[n];
        cnt[0] =1;

        for(int i = 1; i < n; i++){
            dp[i] = 1;
            cnt[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    }else if(dp[j] + 1 == dp[i]){
                        cnt[i] += cnt[j];
                    }
                }
            }
            //System.out.println(dp[i] + "--" + max);
            if(dp[i] > max){
                max = dp[i];
                count = cnt[i];
            }else if(dp[i] == max){
                count += cnt[i];
            }
        }
        //System.out.println(Arrays.toString(dp));
        return count;
    }

    public int findNumberOfLIS2(int[] nums) {
        return 1;
    }
}
