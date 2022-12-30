package Year2022.Week.W310;

import java.util.HashMap;
import java.util.Map;

public class q2404 {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = -1, ansNum = -1;
        for(int num : nums){
            if(num %  2 == 0){
                int cnt = map.getOrDefault(num, 0);
                if(cnt + 1 > ans){
                    ans = cnt + 1;
                    ansNum = num;
                }else if(cnt + 1 == ans){
                    if(num < ansNum){
                        ansNum = num;
                    }
                }
                ans = Math.max(cnt + 1, ans);
                map.put(num, cnt + 1);
            }
        }

        return ansNum;
    }
}
