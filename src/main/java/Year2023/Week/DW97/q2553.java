package Year2023.Week.DW97;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class q2553 {
    public int[] separateDigits(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];

            while (num != 0){
                ans.add(num % 10);
                num /= 10;
            }
        }

        Collections.reverse(ans);
        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
}
