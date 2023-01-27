package Year2023.Daily.M1.D27;

import java.util.HashSet;
import java.util.Set;

public class q2309 {
    public String greatestLetter(String s) {
        // 位运算
        int lower = 0, upper = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(Character.isLowerCase(c)){
                lower |= 1 << (c - 'a');
            }else {
                upper |= 1 << (c - 'A');
            }
        }

        for (int i = 26; i >= 0; i--) {
            if((lower & upper & (1 << i)) != 0){
                return String.valueOf((char) ('A' + i));
            }
        }

        return "";
    }
}
