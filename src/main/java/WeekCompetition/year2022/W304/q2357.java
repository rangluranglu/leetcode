package WeekCompetition.year2022.W304;

import java.util.Arrays;

public class q2357 {
    public static void main(String[] args) {
        int[] nums = {1,5,0,3,5};
        System.out.printf("" + minimumOperations(nums));
    }
    public static int minimumOperations(int[] nums) {
        Arrays.sort(nums);

        int ans = 0;
        int d = 0;
        for (int i = 0; i < nums.length; i++) {
            int res = nums[i] - d;
            if(res == 0){
                continue;
            }

            d += res;
            ans += 1;
        }
        return ans;

    }
}
