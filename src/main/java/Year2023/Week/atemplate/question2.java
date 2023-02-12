package Year2023.Week.atemplate;

import java.lang.reflect.Array;
import java.util.*;

public class question2 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        // 统计公平数对
        Arrays.sort(nums);
        int ans = 0, n = nums.length;
        int last = n -1, start = 0;
        while (nums[last] > upper){
            last --;
        }

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int cnt = 0;

            while (num + nums[last] <)

        }
    }
}
