package Year2023.Daily.M1.D19;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class q2299 {
    public boolean strongPasswordCheckerII(String password) {
        char[] pass = password.toCharArray();

        int n = pass.length;
        if(n < 8){
            return false;
        }
        Set<Character> specials = new HashSet<Character>() {{
            add('!');
            add('@');
            add('#');
            add('$');
            add('%');
            add('^');
            add('&');
            add('*');
            add('(');
            add(')');
            add('-');
            add('+');
        }};

        boolean loserCase = false, upperCase = false, digitCase = false, specialCase = false;
        for (int i = 0; i < n; i++) {
            char c = pass[i];

            if(i != n - 1 && c == pass[i + 1]){
                return false;
            }

            if(Character.isDigit(c)){
                digitCase = true;
            }else if(Character.isLowerCase(c)){
                loserCase = true;
            }else if(Character.isUpperCase(c)){
                upperCase = true;
            }else if(specials.contains(c)){
                specialCase = true;
            }
        }


        return loserCase && upperCase && digitCase && specialCase;
    }
}
