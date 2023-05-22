package Year2023.Daily.M5.D21;

import java.util.Arrays;

public class LCP33 {
    public int storeWater(int[] bucket, int[] vat) {
        int n = bucket.length;

        int maxk = Arrays.stream(vat).max().getAsInt();
        if(maxk == 0){
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        for(int k = 1; k <= maxk && k < ans; k++){
            int t = 0;

            for(int i = 0; i < bucket.length; i++){
                // 向上取整
                t += Math.max(0, (vat[i] + k - 1) / k - bucket[i]);
            }
            ans = Math.min(ans, t + k);
        }

        return ans;

    }
}
