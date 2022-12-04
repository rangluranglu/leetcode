package WeekCompetition.year2022.atemplate;

import Common.TreeNode;

import java.util.*;

public class question2 {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int group = n / 2;

        int sum = Arrays.stream(skill).sum();

        int pre = sum / group;
        System.out.println(pre);
        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        for(int sk : skill){
            if(map.containsKey(pre - sk)){
                ans += (long) sk * (pre - sk);
                map.put(pre - sk, map.get(pre - sk) - 1);
                if(map.get(pre - sk) == 0){
                    map.remove(pre - sk);
                }
            }else {
                map.put(sk, map.getOrDefault(sk, 0) + 1);
            }
        }

        if(map.size() > 0){
            return -1;
        }

        return ans;
    }
}
