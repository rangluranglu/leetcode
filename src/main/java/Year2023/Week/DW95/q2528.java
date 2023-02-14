package Year2023.Week.DW95;

public class q2528 {

    // 二分答案 + 前缀和 + 差分数组 + 贪心
    public long maxPower(int[] stations, int r, int k) {
        // 最小的最大值  最小供电站的最大值

        // 二分答案
        // 1. 确定左右范围
        // 2. 如何判是否符合

        int n = stations.length;
        // 前缀和
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + stations[i - 1];
        }

        long mn = Long.MAX_VALUE; // 初始最小电量
        long[] power = new long[n]; // 电量
        for (int i = 0; i < n; i++) {
            power[i] = sum[Math.min(i + r + 1, n)] - sum[Math.max(i - r, 0)];
            mn = Math.min(mn, power[i]);
        }

        long left = mn, right = mn + k + 1; // 开区间 [)
        while (left < right){
            long mid = left + (right - left) / 2;

            if(check(mid, power, n, r, k)){
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return left - 1;
    }

    public boolean check(long minPower, long[] power, int n, int r, int k){
        // 差分数组
        long[] diff = new long[n + 1];

        long sumD = 0, need = 0;
        for (int i = 0; i < n; i++) {
            sumD += diff[i];  // 累加差分值
            long m = minPower - power[i] - sumD;

            if(m > 0){
                // 需要m个供电站
                need += m;
                if(need > k){
                    return false;
                }
                sumD += m; // 更新差分
                if(i + r * 2 + 1 < n){
                    diff[i + r * 2 + 1] -= m;
                }
            }
        }

        return true;
    }


}
