package Year2023.Daily.M5.D19;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class q1079 {
    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : tiles.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 回溯
        Set<Character> title = new HashSet<>(map.keySet());

        return dfs(title.size(), map, title) - 1;


    }

    private int dfs(int i, Map<Character, Integer> map, Set<Character> set){
        if(i == 0){
            return 1;
        }

        int res = 1;
        for(char t : set){
            if(map.get(t) > 0){
                map.put(t, map.get(t) - 1);
                res += dfs(i - 1, map, set);
                map.put(t, map.get(t) + 1);
            }
        }

        return res;
    }
}
