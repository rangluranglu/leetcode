package Year2023.Week.W345;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q2682 {
    public int[] circularGameLosers(int n, int k) {
        // 模拟

        boolean[] visited = new boolean[n];
        for(int i = 0, step = k; !visited[i];step += k){

            visited[i] = true;
            i = (i + step) % n;
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if(!visited[i]) ans.add(i + 1);
        }

        return ans.stream().mapToInt(a -> a).toArray();

    }
}
