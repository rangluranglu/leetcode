package Year2023.Week.DW100;

import java.util.Arrays;

public class q2594 {
    public long repairCars(int[] ranks, int cars) {
        // r * n ^2 的时间修理汽车
        // 可以同时修车， 最少的时间
        // 分配汽车 使时间尽可能相等

        // n^2 是抛物线，

        // 排序
        // 二分答案

        Arrays.sort(ranks);

        long left = 0, right = (long) ranks[0] * cars * cars;

        while (left <= right){
            long mid = left + (right - left) / 2;

            // 判断是否正确
            if(check(mid, ranks, cars)){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean check(long hour, int[] ranks, int cars){
        int i = 0;
        while (cars > 0 && i < ranks.length){
            cars -= (long) Math.sqrt(hour / ranks[i]);
            i ++;
        }

        return  cars <= 0;
    }
}
