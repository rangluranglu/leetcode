package Year2022.Daily.M8.D12;

import java.util.ArrayList;
import java.util.List;

public class q1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> count = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int n = groupSizes.length;

        for(int i = 0; i <= n; i ++){
            count.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            List<Integer> list = count.get(groupSizes[i]);
            list.add(i);

            if(list.size() == groupSizes[i]){
                ans.add(new ArrayList<>(list));
                list.clear();
            }
        }

        return ans;

    }
}
