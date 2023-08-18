package Year2023.Week.W358;

import java.util.Arrays;

public class q6939 {
    public int maxSum(int[] nums) {
        int ans = -1;

        int[] maxVal = new int[10];
        Arrays.fill(maxVal, Integer.MIN_VALUE);

        for(int v : nums){
            int maxD = 0;

            for(int x = v; x > 0; x /= 10){
                maxD = Math.max(maxD, x % 10);
            }

            ans = Math.max(ans, maxVal[maxD] + v);
            maxVal[maxD] = Math.max(maxVal[maxD], v);
        }

        return ans;
    }
}
