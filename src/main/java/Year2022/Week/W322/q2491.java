package Year2022.Week.W322;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class q2491 {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int group = n / 2;

        int sum = Arrays.stream(skill).sum();

        int pre = sum / group;
        //System.out.println(pre);
        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        for(int sk : skill){
            if(map.containsKey(pre - sk)){
                ans +=  (long) sk * (pre - sk);
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

    public long dividePlayers2(int[] skill) {
        // 排序后匹配， 排序后 最大数和最小数匹配
        Arrays.sort(skill);
        int n = skill.length;
        int sum = skill[0] + skill[n - 1];
        long ans = (long) skill[0] * skill[n - 1];

        for (int i = 1, j = n -2; i < j; i++, j --){
            if(skill[i] + skill[j] != sum){
                return -1;
            }else {
                ans += (long) skill[i] * skill[j];
            }
        }

        return ans;

    }
}
