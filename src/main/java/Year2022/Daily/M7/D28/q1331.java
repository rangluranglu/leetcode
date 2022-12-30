package Year2022.Daily.M7.D28;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class q1331 {
    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArr = new int[arr.length];

        System.arraycopy(arr, 0, sortedArr, 0, arr.length);

        Arrays.sort(sortedArr);
        Map<Integer, Integer> count = new HashMap<>();
        for(int a : sortedArr){
            if(count.containsKey(a)){
                continue;
            }
            count.put(a, count.size() + 1);
        }

        for (int i = 0; i <arr.length; i++) {
            sortedArr[i] = count.get(arr[i]);
        }

        return sortedArr;
    }
}
