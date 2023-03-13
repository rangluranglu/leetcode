package Year2023.Week.W336;

import java.util.HashSet;
import java.util.Set;

public class q2586 {
    public int vowelStrings(String[] words, int left, int right) {
        Set<Character> set = new HashSet<Character>(){{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
        }};
        int ans = 0;
        for (int i = left; i <= right ; i++) {
            if(set.contains(words[i].charAt(0)) && set.contains(words[i].charAt(words[i].length() - 1))){
                ans ++;
            }
        }

        return ans;
    }
}
