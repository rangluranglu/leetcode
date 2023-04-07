package Year2023.Daily.M4.D7;

import java.util.Arrays;

public class q1040 {
    public int[] numMovesStonesII(int[] stones) {
        // 移动石子直到连续
        // 双指针
        int n = stones.length;
        Arrays.sort(stones);

        if(stones[n - 1] - stones[0] + 1 == n){
            return new int[]{0, 0};
        }
        // 第一次只能移动 stones[0] 或 stones[n - 1] 最大：
        // 第一次移动stones[0] 操作次数为： stones[n - 1] - stones[1] + 1 - (n - 1)
        // 第一次移动stones[n - 1]  : stones[n - 2] - stones[0] + 1 - (n - 1)

        // 最小：

        int ma = Math.max(stones[n - 2] - stones[0] + 1, stones[n - 1] - stones[1] + 1) - (n - 1);
        int mi = n;

        for(int i = 0, j = 0; i < n && j + 1 < n; i++){
            while (j + 1 < n && stones[j + 1] - stones[i] + 1 <= n){
                j++;
            }

            if(j - i + 1 == n - 1 && stones[j] - stones[i] + 1 == n - 1){
                mi = Math.min(mi, 2);
            }else{
                mi = Math.min(mi, n - (j - i + 1));
            }
        }

        return new int[]{mi, ma};


    }
}
