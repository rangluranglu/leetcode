package Daily.year2022.M8.D24;

import java.util.HashMap;
import java.util.Map;

public class q1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        if(target.length != arr.length){
            return false;
        }

        int n = target.length;
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> ret = new HashMap<>();

        for(int num : target){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for(int num : arr){
            ret.put(num, ret.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            int key = entry.getKey(), value = entry.getValue();
            if(!ret.containsKey(key) || ret.get(key) != value){
                return false;
            }
        }

        return true;
    }
}
