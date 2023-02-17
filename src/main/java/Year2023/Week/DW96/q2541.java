package Year2023.Week.DW96;

import java.util.Arrays;

public class q2541 {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        // 最小操做数
        long add = 0, reduce = 0;
        int n = nums1.length;
        if(k == 0){
            return Arrays.equals(nums1, nums2) ? 0 : -1;
        }
        for (int i = 0; i < n; i++) {
            int diff = 0;
            if(nums1[i] == nums2[i]){
                continue;
            }
            if(nums1[i] > nums2[i]){
                diff = nums1[i] - nums2[i];
                if(diff % k != 0){
                    return -1;
                }
                reduce += diff / k;
            }else{
                diff = nums2[i] - nums1[i];
                if(diff % k != 0){
                    return -1;
                }
                add += diff / k;
            }
        }

        if(add != reduce){
            return -1;
        }

        return add;

    }
}
