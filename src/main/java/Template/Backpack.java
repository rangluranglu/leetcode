package Template;

public class Backpack {


    // 0-1 背包
    public int backPack01(int[] c, int[] w, int v){
        int n = c.length;

        int[][] dp = new int[n + 1][v + 1];

        for(int i = 1; i <= n; i++){
            // 枚举体积
            for(int j = 0; j <= v; j++){
                dp[i][j] = dp[i - 1][j]; // 不选第i个
                if(j >= c[i - 1]){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - c[i]] + w[i]);
                }
            }
        }

        return dp[n][v];
    }

    // 0-1 背包优化，使用一维数组
    public int backPack012(int[] c, int[] w, int v){
        int n = c.length;

        int[] dp = new int[v + 1];

        for(int i = 1; i <= n; i++){
            // 枚举体积
            // 倒序遍历，保证只使用一次
            // 更新时使用到的前一个状态未被更新
            for(int j = v; j >= c[i]; j++){
                dp[j] = Math.max(dp[j], dp[j - c[i]] + w[i]);
            }
        }
        return dp[v];
    }

    // 完全背包
    public int backPackAll(int[] c, int[] w, int v){
        int n = c.length;

        int[][] dp = new int[n + 1][v + 1];

        for(int i = 1; i <= n; i++){
            // 枚举体积
            for(int j = 0; j <= v; j++){
                // 枚举 枚举物品取用件数 * c[i] 不大于当前体积
                for(int k = 0; k * c[i - 1] <= j; k++){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - c[i - 1] * k] + w[i] * k);
                }
            }
        }

        return dp[n][v];
    }

    // 完全背包时间优化
    public int backPackAllTimes(int[] c, int[] w, int v){
        int n = c.length;

        int[][] dp = new int[n + 1][v + 1];

        for(int i = 1; i <= n; i++){
            // 注意：正向遍历，和01背包不同
            for(int j = 0; j <= v; j++){
                dp[i][j] = dp[i - 1][j];
                if(j >= c[i - 1]){
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - c[i - 1]] + w[i]);
                }
            }
        }
        return dp[n][v];
    }

    // 完全背包空间优化
    public int backPackAllSpace(int[] c, int[] w, int v){
        int n = c.length;

        int[] dp = new int[v + 1];

        for(int i = 1; i <= n; i++){
            for(int j = c[i - 1]; j <= v; j++){
                dp[j] = Math.max(dp[j], dp[j - c[i]] + w[i]);
            }
        }
        return dp[v];
    }

    // 多重背包， 每个物品有个数限制
    // c --> 体积， w --> 价值， s --> 个数
    public int backPackMany(int[] c, int[] w, int[] s, int v){
        int n = c.length;

        int[][] dp = new int[n + 1][v + 1];

        for(int i = 1; i <= n; i++){
            // 枚举体积
            for(int j = 0; j <= v; j++){
                // 枚举 枚举物品取用件数 * c[i] 不大于当前体积
                // 注意：这里加了限制
                for(int k = 0; k <= s[i - 1] && k * c[i - 1] <= j; k++){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - c[i - 1] * k] + w[i] * k);
                }
            }
        }

        return dp[n][v];
    }

    // 多重背包二进制优化
    // 将每一种物品由1,2,4,8,16,128...件数打包， 不足一组的零头重新打包，转化为01背包问题
    public int backPackBinary(int[] c, int[] w, int[] s, int v){
        int n = c.length;

        // 打包后的包数
        int cnt = 0;

        // 打包
        int[] new_c = new int[n];
        int[] new_w = new int[n];

        for (int i = 0; i < n; i++) {
            int a = c[i];
            int b = w[i];
            int d = s[i];

            int k = 1;
            while(k <= d){
                cnt ++;

                new_c[cnt] = k * a;
                new_w[cnt] = k * b;

                d -= k;
                k *= 2;
            }

            if(d > 0){
                // 有剩余
                cnt ++;
                new_c[cnt] = a * d;
                new_w[cnt] = b * d;
            }
        }

        // 01 背包
        n = cnt;
        int[] dp = new int[v + 1];
        for(int i = 1; i <= n; i++){
            // 枚举体积

            for(int j = v; j >= new_w[i - 1]; j--){
                dp[j] = Math.max(dp[j], dp[j - new_c[i - 1]] + new_w[i - 1]);
            }

        }

        return dp[v];
    }


    // 分组背包
    // toda

}
