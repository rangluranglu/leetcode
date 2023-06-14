package Year2023.Week.DW100;

import java.util.Arrays;

public class q2592 {
    public int maximizeGreatness(int[] nums) {
        // prem[i] > nums[i] 的下标数目最大

        // 排序
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
}
