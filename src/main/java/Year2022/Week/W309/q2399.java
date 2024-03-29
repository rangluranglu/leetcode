package Year2022.Week.W309;

import java.util.Arrays;

public class q2399 {
    public boolean checkDistances(String s, int[] distance) {
        int[] count = new int[26];
        int n = s.length();
        Arrays.fill(count, -1);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(count[c - 'a'] == -1){
                count[c - 'a'] = i;
            }else {
                count[c - 'a'] = i - count[c - 'a'] - 1;
                if(count[c - 'a'] != distance[c - 'a']){
                    return false;
                }
            }
        }

        return true;
    }
}
