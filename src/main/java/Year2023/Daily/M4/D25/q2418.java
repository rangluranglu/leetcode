package Year2023.Daily.M4.D25;

import java.util.Arrays;

public class q2418 {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;

        Integer[] index = new Integer[n];

        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        Arrays.sort(index, (a, b) -> heights[b] - heights[a]);

        String[] ans = new String[n];

        for (int i = 0; i < n; i++) {
            ans[i] = names[index[i]];
        }

        return ans;

    }
}
