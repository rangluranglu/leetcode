package Year2023.Daily.M5.D14;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class q1054 {
    public int[] rearrangeBarcodes(int[] barcodes) {

        // n是奇数且出现最多的元素 n + 1/ 2时， 次数最多的元素必须在偶数

        int n = barcodes.length;
        if(n < 2){
            return barcodes;
        }

        int maxCount = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for(int b : barcodes){
            count.put(b, count.getOrDefault(b, 0) + 1);
            maxCount = Math.max(maxCount, count.get(b));
        }

        int evenIndex = 0;
        int oddIndex = 1;

        int halfLength = n / 2;
        int[] res = new int[n];

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int x = entry.getKey();
            int c = entry.getValue();

            while (c > 0 && c <= halfLength && oddIndex < n){
                res[oddIndex] = x;
                c --;
                oddIndex +=2;
            }

            // c > halfLeng
            while (c > 0){
                res[evenIndex] = x;
                c --;
                evenIndex += 2;
            }
        }

        return res;

    }

}
