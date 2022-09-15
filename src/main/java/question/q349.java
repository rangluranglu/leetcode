package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class q349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        List<Integer> ans = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        while(i < m && j < n){
            int num1 = nums1[i], num2 = nums2[j];

            if(num1 == num2){
                if(ans.size() == 0 || num1 != ans.get(ans.size() - 1)){
                    ans.add(num1);
                }

                i++;
                j++;
            }else if(num1 < num2){
                i++;
            }else {
                j++;
            }
        }

        int[] ret = new int[ans.size()];
        for (int k = 0; k <ans.size(); k++) {
            ret[k] = ans.get(k);
        }

        return ret;
    }
}
