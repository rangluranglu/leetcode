package Daily.year2022.M11.D15;

import java.util.Arrays;

public class q1710 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // dp 背包问题
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int ans = 0;
        for(int[] boxType : boxTypes){
            int num = boxType[0];
            int unitNum = boxType[1];

            if(num < truckSize){
                ans += num * unitNum;
                truckSize -= num;
            }else {
                ans += truckSize * unitNum;
                break;
            }
        }

        return ans;



    }
}
