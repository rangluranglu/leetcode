package Year2023.Week.W351;

import java.util.Arrays;

public class q2750 {

    private static int mod = (int) 1e9 + 7;
    public int numberOfGoodSubarraySplits(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        if(sum == 1){
            return 1;
        }

        if(sum == 0){
            return 0;
        }

        // 两个1中间0的个数
        long ans = 1;
        int lastIndex = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                if(lastIndex == -1){
                    lastIndex = i;
                }else {
                    ans = ((ans % mod) *  (i - lastIndex)) % mod;
                    lastIndex = i;
                }
            }
        }

        return(int) ans;
    }


}
