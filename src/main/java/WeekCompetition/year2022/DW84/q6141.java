package WeekCompetition.year2022.DW84;

import java.util.ArrayList;
import java.util.List;

public class q6141 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        int[] count = new int[1001];

        for(int[] item: items1){
            count[item[0]] += item[1];
        }

        for(int[] item: items2){
            count[item[0]] += item[1];
        }

        List<List<Integer>> ret = new ArrayList<>();
        for(int i = 1; i <= 1000; i++){
            if(count[i] != 0){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                tmp.add(count[i]);
                ret.add(tmp);
            }
        }

        return ret;
    }
}
