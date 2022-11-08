package Daily.year2022.M11.D8;

import java.util.HashSet;
import java.util.Set;

public class q1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for(char a : allowed.toCharArray()){
            set.add(a);
        }
        int ans = 0;
        flag:
        for(String word : words){
            for (int i = 0; i < word.length(); i++) {
                if(!set.contains(word.charAt(i))){
                    continue  flag;
                }
            }
            ans ++;
        }

        return ans;
    }
}
