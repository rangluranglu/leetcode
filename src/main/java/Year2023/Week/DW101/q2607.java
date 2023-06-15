package Year2023.Week.DW101;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class q2607 {
    public long makeSubKSumEqual(int[] arr, int k) {
        // 修改成元素一样

        // 中位数贪心 --> 变为中位数是最优
        // 一个循环数组如果既有周期 n，又有周期 k，则必然有周期 gcd(n,k)。
        //裴蜀定理  a[i] = a[i + nx + ky] = a[i + gcd(n, k)]


        int n = arr.length;
        k = gcd(k, n);

        long ans = 0L;
        for (int i = 0; i < k; i++) {
            List<Integer> b = new ArrayList<>();
            for (int j = i; j < n; j += k)
                b.add(arr[j]);

            Collections.sort(b);
            int mid = b.get(b.size() / 2);
            for(int x : b) ans += Math.abs(x - mid);
        }

        return ans;
    }

    private int gcd(int a, int b){
        while (a != 0){
            int tmp = a;
            a = b % a;
            b = tmp;
        }

        return b;
    }
}
