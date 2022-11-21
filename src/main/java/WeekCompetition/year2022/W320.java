package WeekCompetition.year2022;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class W320 {

    public int unequalTriplets(int[] nums) {
        // 暴力
        Map<Integer, Integer> map  = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        if(map.size() < 3){
            return 0;
        }
        int[] value = new int[map.size()];
        int index = 0;

        for (int val : map.values()) {
            value[index] = val;
            index++;
        }

        int ans = 0;
        for (int i = 0; i < value.length - 2; i++) {
            for (int j = i + 1; j < value.length - 1; j++) {
                for(int k = j + 1; k < value.length; k++){
                    ans += (value[i] * value[j] * value[k]);
                }
            }
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

    public int unequalTriplets2(int[] nums) {
        // 利用对称性，
        // 在x 之前遍历过的数有a个
        // 当前遍历等于x的数有b个
        // 在x 之后遍历过的数有c个

        Map<Integer, Integer> map = new HashMap<>();
        for(int num :nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        int n = nums.length;
        int a = 0;
        for (Integer value : map.values()) {
            n -= value;
            ans += a * value * n;
            a += value;
        }

        return ans;

    }

}
