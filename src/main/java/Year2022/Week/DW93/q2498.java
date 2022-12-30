package Year2022.Week.DW93;

public class q2498 {
    public int maxJump(int[] stones) {
        // 每块石头最多到达一次
        // 抽象问题 --> 最小的最大值

        // 二分答案
        int n = stones.length;
        int left = 0, right = stones[n - 1];

        while (left <= right){
            int mid = left + (right - left) / 2;
            if (check(stones, mid)) {
                right = mid - 1;
            }else {
                left = mid+ 1;
            }
            // 怎么判断？
            //
        }
        return left;

    }

    private boolean check(int[] stones, int mid){
        boolean[] st = new boolean[stones.length];

        for (int i = 0, j = 1; j< stones.length; j++) {
            while (j < stones.length && stones[j] - stones[i] <= mid){
                j ++;
            }

            st[j - 1] = true;
            i = j - 1;
        }

        st[stones.length - 1] = false;
        for (int i = 0, j = 1; j < stones.length; j++) {
            while (j < stones.length && st[j]){
                j ++;
            }

            if(stones[j] - stones[i] > mid){
                return false;
            }
            i = j;
        }

        return true;
    }

    public int maxJump2(int[] stones) {
        // 每块石头最多到达一次
        // 抽象问题 --> 最小的最大值

        int n = stones.length;
        int ans = stones[1]  - stones[0];

        for (int i = 2; i < n; i++) {
            ans = Math.max(ans, stones[i] - stones[i - 2]);
        }

        return ans;

    }
}
