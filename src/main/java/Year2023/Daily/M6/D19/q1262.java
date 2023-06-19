package Year2023.Daily.M6.D19;

public class q1262 {
    public int maxSumDivThree(int[] nums) {
        // 最大和
        // 和 --> 如何计算？ 前缀和？？
        // (a + b) mod 3 = 0;
        // 先计算余数。

        // 动态规划
        int n = nums.length;

        int[][] f = new int[n + 1][3];
        f[0][1] = f[0][2] = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < 3; j++){
                f[i + 1][j] = Math.max(f[i][j], f[i][(j + nums[i]) % 3]  + nums[i]) ;
            }
        }

        return f[n][0];
    }

    public int maxSumDivThree2(int[] nums) {
        // 最大和
        // 和 --> 如何计算？ 前缀和？？
        // (a + b) mod 3 = 0;
        // 先计算余数。

        // 动态规划 --> 优化，滚动数组
        int n = nums.length;

        int[][] f = new int[2][3];
        f[0][1] = f[0][2] = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++){
                f[(i + 1) % 2][j] = Math.max(f[i % 2][j], f[i % 2][(j + nums[i]) % 3] + nums[i]);
            }
        }

        return f[n % 2][0];
    }
}
