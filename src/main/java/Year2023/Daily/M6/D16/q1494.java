package Year2023.Daily.M6.D16;

public class q1494 {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        // 上完所有可 最少需要的学期。
        // 状压dp


        // pre1 存储 i的前置条件。
        int[] pre1 = new int[n];

        for(int[] r : relations){
            pre1[r[1] - 1] |= 1 << (r[0] - 1);  // r[1] 的先修课程集合，下标从0开始
        }
        // u是全集
        int u = (1 << n) - 1;
        // dp
        int[] f = new int[1 << n];
        // 初始化
        f[0] = 0;
        for (int i = 1; i < 1 << n; i++) {
            // i1 ?   ci是i的补集，就是不是前置
            int i1 = 0, ci = u ^ i;  // i的补集

            // 检查是否在
            for(int j = 0; j < n; j++){
                if((i >> j & 1) > 0 && (pre1[j] | ci) == ci)  // pre[j] 在i的补集中, 可以学，否则一定不能学
                    i1 |= 1 << j;
            }

            if(Integer.bitCount(i1) <= k){
                // 如果个数小于 k，则可以全部学习，不再枚举子集
                f[i] = f[i ^ i1] + 1;
                continue;
            }

            // 可以学的课程大于k， 要分开学习
            // 枚举子集
            f[i] = Integer.MAX_VALUE;
            // (j - 1) & i1 枚举子集
            for (int j = i1; j > 0; j = (j - 1) & i1) {
                // 子集可以学k个，学的越多越好
                if(Integer.bitCount(j) == k){
                    // j是子集
                    f[i] = Math.min(f[i], f[i ^ j] + 1);
                }
            }
        }
        return f[u];
    }
}
