package Year2022.Daily.M11.D11;

import java.util.HashSet;
import java.util.Set;

public class q1704 {
    char[] yuan = {'a', 'e', 'i', 'o', 'u'};
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        for (char o : yuan) {
            set.add(o);
            set.add(Character.toUpperCase(o));
        }

        for (int i = 0; i < n / 2; i++) {
            if(set.contains(s.charAt(i))) left++;
            if(set.contains(s.charAt(i + n / 2))) right ++;
        }

        return left == right;
    }
}
