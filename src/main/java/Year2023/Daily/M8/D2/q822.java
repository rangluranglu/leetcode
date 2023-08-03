package Year2023.Daily.M8.D2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class q822 {
    public int flipgame(int[] fronts, int[] backs) {
        // 找到最小值
        Collections.reverse();
        Set<Integer> same = new HashSet<>();

        for(int i = 0; i < fronts.length; i++){
            if(fronts[i] == backs[i]){
                same.add(fronts[i]);
            }
        }

        int res = 3000;
        for(int i = 0; i < fronts.length; i++){
            if(fronts[i] < res && !same.contains(fronts[i])){
                res = fronts[i];
            }
            if(backs[i] < res && !same.contains(backs[i])){
                res = backs[i];
            }
        }

        return res == 3000 ? 0 : res;
    }
}
