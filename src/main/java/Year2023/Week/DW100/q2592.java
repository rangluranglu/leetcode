package Year2023.Week.DW100;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class q2592 {
    public int maximizeGreatness(int[] nums) {
        // prem[i] > nums[i] 的下标数目最大

        // 排序
        // 时间复杂度 O(nlogn)
        Arrays.sort(nums);

        // 找到下一个数
        int prev = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == nums[prev]){
                continue;
            }
            prev ++;
        }

        return prev;
    }

    public int maximizeGreatness2(int[] nums) {
        // 优化
        // 考虑无法匹配的个数m

        // x = nums[j],  每次 x > nums[i] 不成立时， 两个指针错开的距离 j - i 就 +1
        // 结束后 j - i就是m, 可以证明得到， m 就是 nums中元素出现次数的最大值。
        int mx = 0;
        Map<Integer, Integer> cnt = new HashMap<>();

        for(int x : nums){
            mx = Math.max(mx, cnt.merge(x, 1, Integer::sum));
        }

        return nums.length - mx;
    }
}
