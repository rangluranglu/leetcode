package Year2023.Daily.M6;

import java.util.Arrays;

public class q2517 {
    public int maximumTastiness(int[] price, int k) {
        // k类，  最大的最小值
        // 二分答案

        int n = price.length;
        Arrays.sort(price);

        int left = 0, right =price[n - 1];

        while (left <= right){
            int mid = left + (right - left) / 2;

            // mid 是否符合要求 mid 是否是最大的最小值
            // 贪心
            int last = price[0];
            int cur = 1;
            for (int i = 1; i < n; i++) {
                if(price[i] - last >= mid){
                    cur ++;
                    last = price[i];
               }
            }

            if(cur >= k){
                left = mid + 1;
            }else {
                right = mid - 1;
            }

        }

        return right;

    }

    public int maximumTastiness2(int[] price, int k) {
        // k类，  最大的最小值
        // 二分答案

        int n = price.length;
        Arrays.sort(price);

        int left = 0, right =price[n - 1];

        while (left <= right){
            int mid = left + (right - left) / 2;

            // mid 是否符合要求 mid 是否是最大的最小值
            // 二分

            int last = price[0];
            int cur = 1;
            for (int i = 1; i < n; i++) {
                if(price[i] - last >= mid){
                    cur ++;
                    last = price[i];
                }
            }

            if(cur >= k){
                left = mid + 1;
            }else {
                right = mid - 1;
            }

        }

        return right;

    }
}
