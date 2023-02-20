package Year2023.Daily.M2.D20;

import java.util.HashMap;
import java.util.Map;

public class q2347 {
    public String bestHand(int[] ranks, char[] suits) {
        // 花色
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            if(suits[i] != suits[i + 1]){
                flag = false;
            }
        }

        if(flag){
            return "Flush";
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int rank: ranks){
            map.put(rank, map.getOrDefault(rank, 0) + 1);
        }

        if(map.size() == 5){
            return "High Card";
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > 2){
                return "Three of a Kind";
            }
        }

        return "Pair";
    }
}
