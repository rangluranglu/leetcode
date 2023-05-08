package Year2023.Week.DW97;

import java.util.HashSet;
import java.util.Set;

public class q2554 {
    public int maxCount(int[] banned, int n, int maxSum) {
        // 贪心 --> 最多，那就从最小的选起

        Set<Integer> set = new HashSet<>();
        for(int ban : banned){
            set.add(ban);
        }


        int sum = 0, cnt = 0;
        for (int i = 1; i <= n; i++) {
            if(!set.contains(i)){
                sum += i;
                cnt += 1;

                if(sum > maxSum){
                    return cnt - 1;
                }
            }
        }

        return cnt;

    }
}
