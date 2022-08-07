package question;

public class q300 {
    public int lengthOfLIS1(int[] nums) {
        // 动态规划
        int n = nums.length;
        if(n == 0){
            return 0;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        int ans = 1;
        for(int i = 1; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    public int lengthOfLIS2(int[] nums) {
        // 贪心 + 二分
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        // 表示长度为 ii 的最长上升子序列的末尾元素的最小值
        int[] d = new int[n + 1];
        int len = 1;
        d[len] = nums[0];

        for(int i = 1; i < n; i++){
            if(nums[i] > d[len]){
                d[++len] = nums[i];
            }else{
                int l = 1, r = len;

                while(l <= r){
                    int mid = (l + r) >> 1;

                    if(d[mid] < nums[i]){
                        l = mid + 1;

                    }else{
                        r = mid - 1;
                    }
                }
                d[l > len ? 0 : l] = nums[i];
            }
        }
        return len;



    }
}
