package WeekCompetition.year2022.W316;

public class q2447 {

    public int subarrayGCD(int[] nums, int k) {
        // 最大公因数等于k 的子数组数目
        // 长度1000 ，可以暴力


        // 动态规划dp[n][n]， dp[i][j] 是子数组nums[i...j]的最大公因数， 状态转移方程为：
        // dp[i][j] = gcd(dp[i][j - 1], nums[j]), 最后统计

        int n = nums.length;
        int ans = 0;

        int[][] dp = new int[n][n];

        // 初始化
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
            if(nums[i] == k){
                ans += 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = gcd(nums[j], dp[i][j - 1]);
                if(dp[i][j] % k != 0){
                    break;
                }
                if(dp[i][j] == k){
                    ans += 1;
                }
            }
        }

        return ans;
    }

    private int gcd(int a, int b) {

        // 辗转相除计算gcd 保证 a > b
        if(b > a){
            return gcd(b, a);
        }

        // a > b
        int sum = a % b;

        while (sum != 0){
            a = b;
            b =sum;
            sum = a % b;
        }

        return b;
    }


}
