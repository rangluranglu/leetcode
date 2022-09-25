package Daily.year2022.M9.D24;

import java.util.Arrays;

public class q1652 {
    public int[] decrypt(int[] code, int k) {
        if(k < 0){
            decrypt(reverce(code), -k);
        }
        // 滑动窗口
        int n = code.length;
        int sum = 0;
        for (int i = 1; i <= k; i++) {
            sum += code[i];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = sum;
            sum -= code[(i + 1) % n];
            sum += code[(i + 1 + k) % n];
        }

        return ans;
    }

    private int[] reverce(int[] code){
        int l = 0, r = code.length - 1;
        while(l < r){
            int tmp = code[l];
            code[l] = code[r];
            code[r] = tmp;
            l ++;
            r --;
        }

        return code;
    }
}
