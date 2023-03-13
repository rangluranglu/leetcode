package Year2023.Week.W336;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q2589 {
    public int findMinimumTime(int[][] tasks) {
        // 贪心 + 暴力
        // 右端点排序

        Arrays.sort(tasks, (a, b) -> a[1] - b[1]);
        int ans = 0;

        boolean[] run = new boolean[tasks[tasks.length - 1][1] + 1];

        for(int[] task : tasks){
            int start = task[0], end = task[1], d = task[2];

            for(int i = start; i <= end; i++){
                if(run[i]){
                    d--;
                }
            }

            for(int i = end; d > 0; i--){
                if(!run[i]){
                    run[i] = true;
                    d--;
                    ans ++;
                }
            }
        }

        return ans;

    }
}
