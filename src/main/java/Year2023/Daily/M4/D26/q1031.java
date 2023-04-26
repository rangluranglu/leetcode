package Year2023.Daily.M4.D26;

public class q1031 {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        // 不重叠

        // 滑动窗口 ?
        // 子数组， 前缀和 + 如何处理不重叠问题？？
        // 两种 有先找 firstLen, 和 优先找 secondLen
        // 不对，可能
        // 使用动态规划 ：
        // dp[i] 为 [0, i] 中长度为firstLen的最大子数组和

        int a = find(nums, firstLen, secondLen);
        int b = find(nums, secondLen, firstLen);
        return Math.max(a, b);
    }

    public int find(int[] nums, int firstLen, int secondLen){
        int suml= 0;

        // 滑动窗口 second 在前， first在后
        for (int i = 0; i < firstLen; i++) {
            suml += nums[i];
        }

        int maxSumL = suml;

        int sumr = 0;
        for(int i = firstLen; i < firstLen +secondLen; i++){
            sumr += nums[i];
        }

        int res = sumr + maxSumL;

        for(int i = firstLen + secondLen, j = firstLen; i < nums.length; i++, j++){
            // 维护两个滑动窗口
            suml += nums[j] - nums[j - firstLen];
            maxSumL = Math.max(maxSumL, suml);

            sumr += nums[i] - nums[i - secondLen];
            res = Math.max(res, maxSumL + sumr);
        }

        return res;
    }
}
