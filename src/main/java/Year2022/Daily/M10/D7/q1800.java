package Year2022.Daily.M10.D7;

public class q1800 {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;

        int dp = nums[0];
        int ans = nums[0];
        for (int i = 1; i < n; i++) {
            if(nums[i] > nums[i - 1]){
                dp = nums[i] + dp;
            }else {
                dp = nums[i];
            }

            ans = Math.max(dp, ans);
        }

        return ans;

    }
}
