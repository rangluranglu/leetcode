package question;

import java.util.ArrayList;
import java.util.List;

public class q986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList<>();

        int i = 0, j = 0;
        int m = firstList.length, n = secondList.length;
        if(m ==0 || n == 0){
            return new int[0][0];
        }
        while(i < m && j < n){
            int lo = Math.max(firstList[i][0], secondList[j][0]);
            int hi = Math.min(firstList[i][1], secondList[j][1]);

            if(lo <= hi){
                ans.add(new int[]{lo, hi});
            }

            if(firstList[i][1] < secondList[j][1]){
                i++;
            }else {
                j ++;
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
