package Daily.year2022.M8.D18;

import java.util.HashMap;
import java.util.Map;

public class q1224 {
    public int maxEqualFreq(int[] nums) {
        // 长度相同的次数
        Map<Integer, Integer> freq = new HashMap<>();

        // nums[i] 出现的次数
        Map<Integer, Integer> count = new HashMap<>();

        int maxFreq = 0, ret = 0;
        for (int i = 0; i < nums.length; i++) {
            if(count.getOrDefault(nums[i], 0) > 0){
                freq.put(count.get(nums[i]), freq.get(count.get(nums[i])) - 1);
            }

            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);

            maxFreq = Math.max(maxFreq, count.get(nums[i]));
            freq.put(count.get(nums[i]), freq.getOrDefault(count.get(nums[i]), 0) + 1);

            boolean ok = maxFreq == 1 ||
                    freq.get(maxFreq) * maxFreq + freq.get(maxFreq - 1) * (maxFreq - 1) == i + 1 && freq.get(maxFreq) == 1 ||
                    freq.get(maxFreq) * maxFreq + 1 == i + 1 && freq.get(1) == 1;

            if(ok){
                ret = Math.max(ret, i + 1);
            }


        }
        return ret;
    }
}
