package Year2023.Week.W350;

public class q2750 {

    private static final int MOD = (int) 1e9 + 7;
    private int[][] f = new int[1 << 14][14];
    // 表示当前可以选的下标集合为 i，上一个选的数的下标是 j 时，可以构造的特殊排列
    private int n;


    public int specialPerm(int[] nums) {
        // 特别的排列
        // dp
        // 状态压缩 dp

        // （a + b) mod m = ((a mod m) + (b mod m)) mod m
        // (a * b) mod m = ((a mod m) * (b mod m)) mod m
        // 可以设 a = k1m + r1, b = k2m + r2;
        // (a + b) mod m = (r1 + r2) mod m
        // (a * b) mod m = (r1 * r2) mod m

        // 记忆化搜索
        n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + dfs(((1 << n) - 1) ^ (1 << i), i, nums))% MOD;
        }
        return ans % MOD;
    }


    private int dfs(int i, int j, int[] nums){
        // 全都选完
        if (i == 0){
            return 1;
        }

        if (f[i][j] > 0){
            return f[i][j];
        }

        int res = 0;
        for(int k = 0; k < n; k++){
            if(((i >> k) & 1) == 1 && (nums[j] % nums[k] == 0 || nums[k] % nums[j] == 0)){
                res = (res + dfs(i ^ (1 << k), k, nums)) % MOD;
            }
        }

        return f[i][j] = res % MOD;
    }


    public int specialPerm2(int[] nums) {
        // 动态规划
        n = nums.length;
        int[][] dp = new int[1 << n][n];

        for (int i = 0; i < n; i++) {
            // 初始化
            dp[0][i] = 1;
        }

        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++){
                    if(((i >> k) & 1) == 1 && (nums[j] % nums[k] == 0 || nums[k] % nums[j] == 0)){
                        dp[i][j] = (dp[i][j] + dp[i ^ (1 << k)][k]) % MOD;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + dp[((1 << n) - 1) ^ (1 << i)][i]) % MOD;
        }

        return ans;
    }
}
