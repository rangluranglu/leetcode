package Year2022.Week.W325;

import java.util.Arrays;

public class q2517 {
    public int maximumTastiness(int[] price, int k) {
        // 最大甜蜜度
        // 最大的最小值

        // 二分 怎么判断？？
        Arrays.sort(price);

        int n = price.length;
        int l = 0, r = price[n - 1];

        // 二分答案
        while (l <= r){
            // mid
            int mid = l + (r - l) / 2;

            // mid 判断是否符合条件
            int last = price[0];
            int cur = 1;
            for (int i = 1; i < n; i++) {
                if(price[i] - last >= mid){
                    cur ++;
                    last = price[i];
                }
            }

            // 满足条件，
            if(cur >= k){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }

        return r;
    }
}
