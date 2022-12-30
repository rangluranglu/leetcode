package Year2022.Week.DW91;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class q2465 {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<Double> set = new HashSet<>();
        for(int i = 0; i <= n / 2; i++){
            int a = nums[i];
            int b = nums[n - 1 - i];


            set.add(((double )(a+b)) / 2);

        }

        return set.size();
    }
}
