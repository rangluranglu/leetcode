package Year2023.Week.W349;

import java.util.Arrays;

public class q2733 {
    public int findNonMinOrMax(int[] nums) {
        if(nums.length <= 2){
            return -1;
        }

        Arrays.sort(nums);

        return nums[1];
    }

    public int findNonMinOrMax2(int[] nums) {
        if(nums.length <= 2){
            return -1;
        }

        // 在前三个数中
        Arrays.sort(nums,0,3);

        return nums[1];
    }
}
