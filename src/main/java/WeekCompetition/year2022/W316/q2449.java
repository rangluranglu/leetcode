package WeekCompetition.year2022.W316;

import java.util.Arrays;

public class q2449 {
    public long makeSimilar(int[] nums, int[] target) {
        func(nums);
        func(target);

        long ans = 0L;
        for (int i = 0; i < nums.length; i++) {
            ans += Math.abs(nums[i] - target[i]);
        }

        return ans / 4;
    }

    private void func(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 != 0){
                nums[i] = -nums[i];
            }
        }

        Arrays.sort(nums);
    }
}
