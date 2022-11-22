package WeekCompetition.year2022.W319;

public class q2470 {
    public int subarrayLCM(int[] nums, int k) {
        // 最小公倍数

        // dp[i][j] i到j 的最小公杯数
        // dp[i][j] = LCM(dp[i][j - 1], nums[j];

        // dp 不可以 数太大会超出范围移除
        // LCM 规律，

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int l = nums[i];

            for (int j = i; j < nums.length; j++) {
                l = lcm(l, nums[j]);
                if(l == k){
                    ans ++;
                }
            }
        }

        return ans;
    }

    private int lcm(int a, int b){
        return a * b / gcd(a, b);
    }

    private int gcd(int a, int b) {
        if(b > a){
            return gcd(b, a);
        }

        int c = a % b;

        while (c != 0){
            a =  b;
            b = c;
            c = a % b;
        }

        return b;
    }
}
