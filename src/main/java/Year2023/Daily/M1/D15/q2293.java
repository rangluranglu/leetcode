package Year2023.Daily.M1.D15;

import java.util.Map;

public class q2293 {
    public int minMaxGame(int[] nums) {
        // 递归

        int n = nums.length;
        if(n == 1){
            return nums[0];
        }

        int[] newNums = new int[n / 2];
        for (int i = 0; i < n / 2; i++) {
            if(i % 2 == 0){
                newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
            }else{
                newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
            }
        }

        return minMaxGame(newNums);
    }
}
