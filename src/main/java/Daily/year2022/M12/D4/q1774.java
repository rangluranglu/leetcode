package Daily.year2022.M12.D4;

import java.util.Arrays;

public class q1774 {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int min = Arrays.stream(baseCosts).min().getAsInt();

        if(min >= target){
            return min;
        }

        boolean[] can = new boolean[target + 1];
        int res = 2 * target - min;

        for(int b : baseCosts){
            if(b <= target){
                can[b] = true;
            }else {
                res = Math.min(res, b);
            }
        }

        for(int t : toppingCosts){
            for(int count = 0; count < 2; count++){
                for (int i = target; i > 0; --i) {
                    if (can[i] && i + t > target) {
                        res = Math.min(res, i + t);
                    }
                    if (i - t > 0) {
                        can[i] = can[i] | can[i - t];
                    }
                }
            }
        }
        for (int i = 0; i <= res - target; ++i) {
            if (can[target - i]) {
                return target - i;
            }
        }
        return res;

    }
}
