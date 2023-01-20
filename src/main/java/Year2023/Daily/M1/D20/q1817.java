package Year2023.Daily.M1.D20;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class q1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        // 活跃分钟数等于j 的用户数

        Map<Integer, Set<Integer>> userActive = new HashMap<>();

        for(int[] log : logs){
            userActive.computeIfAbsent(log[0], a -> new HashSet<>());
            userActive.get(log[0]).add(log[1]);
        }

        int[] ans = new int[k];
        for(Map.Entry<Integer, Set<Integer>> entry : userActive.entrySet()){
            ans[entry.getValue().size() + 1] ++;
        }

        return ans;
    }
}
