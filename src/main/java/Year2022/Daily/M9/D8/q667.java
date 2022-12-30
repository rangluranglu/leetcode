package Year2022.Daily.M9.D8;

import java.util.Arrays;

public class q667 {
    public int[] constructArray(int n, int k) {

        // 贪心
        // k == 1 时 顺序排列
        // k == n -1 时 1 n 2 n - 1 3 n - 2 ... ...
        // 混合得到 1 2 ... n-k n n-k+1 n-1;
        int idx = 0;
        int ans[] = new int[n];

        for(int i = 1; i < n - k; i++){
            ans[idx ++] = i;
        }
        System.out.println(Arrays.toString(ans));
        for(int i = n - k, j = n; i <= j; ++i, --j){
            ans[idx ++] = i;
            if(i != j){
                ans[idx] = j;
                ++idx;
            }

        }
        return ans;

    }
}
