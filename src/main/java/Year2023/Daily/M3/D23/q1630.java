package Year2023.Daily.M3.D23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        // 排序
        int n = l.length;

        List<Boolean> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int left = l[i], right = r[i];
            int minv = nums[left], maxv = nums[left];

            for (int j = left + 1; j <= right; j++) {
                minv = Math.min(minv, nums[j]);
                maxv = Math.max(maxv, nums[j]);
            }

            if(minv == maxv){
                ans.add(true);
                continue;
            }

            if((maxv - minv) % (right - left) != 0){
                ans.add(false);
                continue;
            }

            int d = (maxv - minv) / (right - left);
            boolean flag = true;
            boolean[] seen = new boolean[right - left + 1];

            for(int j = left; j <= right; j++){
                if((nums[j] - minv) % d != 0){
                    flag = false;
                    break;
                }

                int t = (nums[j] - minv) / d;
                if(seen[t]){
                    flag = false;
                    break;
                }

                seen[t] = true;
            }

            ans.add(flag);
        }

        return ans;
    }
}
