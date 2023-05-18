package Year2023.Week.W344;

import java.util.HashMap;
import java.util.Map;

public class q2670 {
    public int[] distinctDifferenceArray(int[] nums) {
        // 前缀不同元素 - 后缀不同元素
        // 两个map统计
        // 不同元素

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> preMap = new HashMap<>();
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.get(nums[i]) - 1);
            if(map.get(nums[i]) == 0){
                map.remove(nums[i]);
            }
            preMap.put(nums[i], preMap.getOrDefault(nums[i], 0 ) + 1);
            ans[i] = (preMap.size()) - (map.size());
        }
        return ans;
    }
}
