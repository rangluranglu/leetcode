package Year2023.Daily.M5.D23;

import java.util.*;

public class q1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        // 子集个数小于等于numWanted， 最多有useLimit个相同项
        // 最大的分数
        int n = values.length;
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        Arrays.sort(index, (a, b) -> values[b] - values[a]);

        Map<Integer, Integer> visited = new HashMap<>();
        int ans = 0;
        for(int i : index){
            int time = visited.getOrDefault(labels[i], 0) + 1;
            if(time <= useLimit){
                ans += values[i];
                visited.put(labels[i], time);
                numWanted --;
            }

            if(numWanted == 0){
                return ans;
            }
        }

        return ans;
    }
}
