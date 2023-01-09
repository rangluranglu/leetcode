package Year2023.Daily.M1.D9;

import java.util.Arrays;

public class q1806 {
    public int reinitializePermutation(int n) {
        // 直接模拟
        int[] perm = new int[n];
        int[] target = new int[n];

        for (int i = 0; i < n; i++) {
            perm[i] = i;
            target[i] = i;
        }

        int step = 0;

        for(;;){
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                if((i & 1) != 0){
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                }else{
                    arr[i] = perm[i / 2];
                }
            }

            perm = arr;
            step ++;
            if(Arrays.equals(perm, target)){
                break;
            }
        }

        return step;
    }

    public int reinitializePermutation2(int n) {
        // 数学计算
        if(n == 2){
            return 1;
        }

        int step = 1, pow2 = 2;
        while (pow2 != 1){
            step ++;
            pow2 = pow2 * 2 % (n - 1);
        }

        return step;
    }
}
