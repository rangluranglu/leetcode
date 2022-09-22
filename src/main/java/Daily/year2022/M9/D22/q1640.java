package Daily.year2022.M9.D22;

import java.util.HashMap;
import java.util.Map;

public class q1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            map.put(pieces[i][0], i);
        }

        int idx = 0;
        while (idx < arr.length){
            if(!map.containsKey(arr[idx])){
                return false;
            }

            int i = map.get(arr[idx]);
            int[] piece = pieces[i];
            for (int j = 0; j < piece.length; j++) {
                if(arr[idx] != piece[j]){
                    return false;
                }
                idx ++;
            }
        }

        return true;
    }
}
