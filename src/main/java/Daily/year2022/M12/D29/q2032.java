package Daily.year2022.M12.D29;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q2032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        // bitMap
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums1) {
            map.put(i, 1);
        }

        for (int i : nums2) {
            map.put(i, map.getOrDefault(i, 0) | 2);
        }

        for (int i : nums3) {
            map.put(i, map.getOrDefault(i, 0) | 4);
        }

        List<Integer> ans = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getKey(), v = entry.getValue();

            // 判断1 的个数大于2
            if((v & (v - 1)) >= 2){
                ans.add(k);
            }

        }

        return ans;
    }
}
