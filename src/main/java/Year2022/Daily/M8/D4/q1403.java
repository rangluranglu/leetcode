package Year2022.Daily.M8.D4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q1403 {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
        }
        int ans = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = n - 1; i >= 0; i--){
            ans += nums[i];
            res.add(nums[i]);
            if(ans > sum - ans){
                return res;
            }
        }

        return res;
    }
}
