package Daily.year2022.M12.D22;

public class q1799 {
    public int maxScore(int[] nums) {
        // gcd 从小到大
        // 数据集长度最大 14

        // 状态压缩 + 动态规划
        // 使用整s标识数组中数据状态

        int m = nums.length;
        int[] dp = new int[1 << m];  // 1 << m 是 2*m

        // 预先处理gcd
        int[][] gcdTmp = new int[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                gcdTmp[i][j] = gcd(nums[i], nums[j]);
            }
        }

        // 动态规划
        int all = 1 << m;
        // 遍历状态
        for(int s = 1; s < all; s++){
            int t = Integer.bitCount(s);
            if((t & 1) != 0){
                // 奇数
                continue;
            }

            for (int i = 0; i < m; i++) {
                if(((s >> i) & 1) != 0){
                    // 选择了这个数据
                    for(int j = i + 1; j < m; j++){
                        if(((s>>j) & 1) != 0){
                            dp[s] = Math.max(dp[s], dp[s ^ (1 << i) ^ (1 << j)] + t / 2 * gcdTmp[i][j]);
                        }
                    }
                }
            }

        }

        return dp[all - 1];
    }

    private int gcd(int x, int y){
        // 辗转相除
        if(x < y){
            return gcd(y, x);
        }

        int c = x % y;
        while (c != 0){
            x = y;
            y = c;
            c = x % y;
        }

        return y;
    }
}
