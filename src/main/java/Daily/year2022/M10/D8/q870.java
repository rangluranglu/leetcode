package Daily.year2022.M10.D8;

import java.util.Arrays;

public class q870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        // 排序
        int n = nums1.length;

        Integer[] idx2 = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx2[i] = i;
        }
        Arrays.sort(nums1);
        Arrays.sort(idx2, (a, b)-> nums2[a] - nums2[b]);
        int[] ans = new int[n];

        int l = 0, r = n - 1;
        for (int i = 0; i < n; i++) {
            if(nums1[i] > nums2[idx2[l]]){
                ans[idx2[l]] = nums1[i];
                l++;
            }else{
                ans[idx2[r]] = nums1[i];
                r--;
            }
        }

        return ans;

    }
}
