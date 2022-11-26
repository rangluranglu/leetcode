package WeekCompetition.year2022.W320;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class q2475 {
    public int unequalTriplets(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int n = nums.length;
        int prev = 0;
        int ans = 0;

        for (Integer value : map.values()) {
            n -= value;
            ans += prev * value * n;
            prev += value;
        }

        return ans;
    }

    public int unequalTriplets1(int[] nums) {
        // 暴力：分组，对于x， 小于x 的数有a， 等于b， 大于c个， 贡献 a*b*c

        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        int i = 0;

        while (i < nums.length){

            int j = 0;
            while(i + j < nums.length && nums[i] == nums[i + j]){
                j++;
            }

            ans += i * (j) * (n - j - i);
            i += j;
        }

        return ans;
    }
}
