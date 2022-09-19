package WeekCompetition.year2022.W310;

import java.util.HashSet;
import java.util.Set;

public class q2405 {
    public int partitionString(String s) {
        int left = 0;
        Set<Character> set = new HashSet<>();
        int ans = 0;
        for(int right = 0; right < s.length(); right++){
            if(set.contains(s.charAt(right))){
                while (left <= right){
                    set.remove(s.charAt(left));
                    left++;
                }
                ans ++;
            }
            set.add(s.charAt(right));
        }
        if(!set.isEmpty()){
            ans += 1;
        }
        return ans;
    }
}
