package Year2023.Week.W333;

import java.util.ArrayList;
import java.util.List;

public class q2570 {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int[] count = new int[1001];

        for (int[] ints : nums1) {
            count[ints[0]] += ints[1];
        }

        for(int[] ints: nums2){
            count[ints[0]] += ints[1];
        }

        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < 1001; i++) {
            if(count[i] != 0){
                ans.add(new int[]{i, count[i]});
            }
        }

        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
}
