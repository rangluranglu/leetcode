package Year2023.Week.WN355;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class b {
    public long maxArrayValue(int[] nums) {
        // 将前一个小的数 加给后一个大的数
        // 从后往前一次遍历

        int last = nums.length - 1;
        long ans = nums[last], tmp = nums[last];
        while (last >= 1){
            if(nums[last - 1] <= tmp){
                tmp += nums[last - 1];

            }else {
                tmp = nums[last - 1];
            }
            ans = Math.max(tmp, ans);
            last --;
        }

        return ans;
    }

    // 递归
}
