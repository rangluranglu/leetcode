package Year2023.Daily.M6.D2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class q2559 {

    private static final Set<Character> set = new HashSet<Character>(){{
        add('a');
        add('e');
        add('i');
        add('o');
        add('u');
    }};
    public int[] vowelStrings(String[] words, int[][] queries) {
        //  前綴和
        int n = words.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i];
            if(set.contains(words[i].charAt(0)) && set.contains(words[i].charAt(words[i].length() - 1))){
                preSum[i + 1] += 1;
            }
        }

        int m = queries.length;
        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            ans[i] = preSum[queries[i][1] + 1] - preSum[queries[i][0]];
        }

        return ans;
    }
}
