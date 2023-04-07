package Year2023.Week.W339;

import java.util.*;

public class q2610 {
    public List<List<Integer>> findMatrix(int[] nums) {

        Map<Integer, Integer> frqMap = new HashMap<>();

        for(int n : nums){
            frqMap.merge(n, 1, Integer::sum);
        }

        List<List<Integer>> ans = new ArrayList<>();

        while (!frqMap.isEmpty()){
            List<Integer> row = new ArrayList<>();

            Iterator<Map.Entry<Integer, Integer>> iterator = frqMap.entrySet().iterator();

            while(iterator.hasNext()){
                Map.Entry<Integer, Integer> next = iterator.next();
                row.add(next.getKey());
                next.setValue(next.getValue() - 1);
                if(next.getValue() == 0){
                    iterator.remove();
                }
            }

            ans.add(row);
        }

        return ans;

    }
}
