package Year2023.Week.W333;

public class q2572 {
    public static int mod = (int) 1e9 + 7;
    int[] prime = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    int MAXK = 10;
    public int squareFreeSubsets(int[] nums) {
        // 无平方子集
        // 1 <= nums[i] <= 30
        // gcd 是否是1

        // 动态规划
        // 质因数分解，如果一个质数出现了两次以上，不选
        // 小于等于30 的质数只有10个

        // 状态压缩dp
        // dp[i][j] 表示 前i个数的子集中， 质因数出现
        int n = nums.length;
        long[][] dp = new long[n][1 << 10];

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < (1 << MAXK); j++) {
                // 不把第i个数加入子集
                dp[i][j] = dp[i - 1][j];
            }

            int x = nums[i - 1];

            if(check(x)){
                // 是平方数，不能加入子集
                continue;
            }

            int mask = 0;
            for(int j = 0; j < MAXK; j++){
                if(x % prime[j] == 0){
                    mask |= (1 << j);
                }
            }

            // 加入子集
            for(int j = 0; j < (1 << MAXK); j++){
                if((j & mask) == 0){
                    // 可以加入
                    dp[i][j | mask] = (dp[i][j | mask] + dp[i - 1][j]) % mod;
                }
            }
        }

        long ans = 0;
        for(int j = 0; j < (1 << MAXK); j++){
            ans = (ans + dp[n][j]) % mod;
        }

        ans = (ans - 1 + mod) %mod;
        return (int) ans;
    }

    private boolean check(int x){
        for (int i = 0; i < MAXK; i++) {
            if(x % prime[i] == 0){
                return true;
            }
        }

        return false;
    }


}



