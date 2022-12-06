package Daily.year2022.M12.D6;

import java.util.HashSet;
import java.util.Set;

public class q1805 {
    public int numDifferentIntegers(String word) {
        // 双指针

        Set<String> set = new HashSet<>();
        int n = word.length();

        int i = 0;
        while(i < n){
            while (i < n && Character.isLowerCase(word.charAt(i))){
                i++;
            }

            // 去除前导0
            int j = i;
            while(j < n && Character.isDigit(word.charAt(j))){
                j ++;
            }


            // 去除前导0
            while(j - i > 1 && word.charAt(i) == '0'){
                i++;
            }

            if(j <= n && i != j){
                set.add(word.substring(i, j));
            }

            i= j;
        }
        return set.size();
    }
}
