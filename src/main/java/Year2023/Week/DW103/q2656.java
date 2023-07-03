package Year2023.Week.DW103;

import java.util.Arrays;

public class q2656 {
    public int maximizeSum(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();

        return k * max + (k - 1) * k / 2;

    }
}
