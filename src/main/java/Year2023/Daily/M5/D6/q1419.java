package Year2023.Daily.M5.D6;

import java.util.HashMap;
import java.util.Map;

public class q1419 {
    public int minNumberOfFrogs(String croakOfFrogs) {
        // 模拟计数

        // 目前已经
        // croak
        int[] cnt = new int[5];

        Map<Character, Integer> map = new HashMap<Character, Integer>(){{
            put('c', 0);
            put('r', 1);
            put('o', 2);
            put('a', 3);
            put('k', 4);
        }};

        for(int i = 0; i < croakOfFrogs.length(); i++){
            char c = croakOfFrogs.charAt(i);
            int index = map.get(c);

            if(index == 0){
                cnt[index] ++;
                if(cnt[4] > 0){
                    cnt[4] --;
                }
            }else{
                if(cnt[index - 1] == 0){
                    return -1;
                }

                cnt[index - 1] --;
                cnt[index] ++;
            }
        }
        if(cnt[0] != 0 || cnt[1] != 0 || cnt[2] != 0 || cnt[3] != 0){
            return -1;
        }

        return cnt[4];
    }
}
