package Year2023.Daily.M6.D29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q1253 {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        // 模拟
        int n = colsum.length;

        int count2 = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if(colsum[i] == 2){
                count2 ++;
            }
            sum += colsum[i];
        }
        upper -= count2;
        lower -= count2;

        if(upper < 0 || lower < 0 || upper + lower != sum + 2 * count2){
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<List<Integer>>(){{
            add(new ArrayList<>());
            add(new ArrayList<>());
        }};

        for(int i = 0; i < n; i++){
            if(colsum[i] == 2){
                ans.get(0).add(1);
                ans.get(1).add(1);
            }else if (colsum[i] == 1){
                if(upper > 0){
                    ans.get(0).add(1);
                    ans.get(1).add(0);
                    upper --;
                }else {
                    ans.get(0).add(0);
                    ans.get(1).add(1);
                    lower --;
                }
            }else {
                ans.get(0).add(0);
                ans.get(1).add(0);
            }
        }

        return ans;
    }
}
