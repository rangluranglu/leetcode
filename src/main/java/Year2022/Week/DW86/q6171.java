package Year2022.Week.DW86;

import java.util.HashSet;
import java.util.Set;

public class q6171 {
    public boolean findSubarrays(int[] nums) {
        Set<Long> ans = new HashSet<>();
        int n = nums.length;

        for(int i = 0; i < n - 1; i++){
            if(ans.contains((long)nums[i] + nums[i+1])){
                return true;
            }

            ans.add((long)nums[i] + nums[i + 1]);
        }

        return false;
    }
}
