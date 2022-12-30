package Year2022.Daily.M10.D17;

import java.util.HashMap;
import java.util.Map;

public class q904 {
    public int totalFruit(int[] fruits) {
        // 最长包含1， 2 的子串

        int ans = 0;
        int left = 0;
        Map<Integer, Integer> cnt = new HashMap<>();

        for(int right = 0; right < fruits.length; right++){
            cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0) + 1);
            while (cnt.size() > 2){
                cnt.put(fruits[left], cnt.get(fruits[left]) - 1);
                if(cnt.get(fruits[left]) == 0){
                    cnt.remove(fruits[left]);
                }

                left ++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
