package Year2023.Week.DW99;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;

public class q2580 {

    static int mode = (int) 1e9 + 7;
    public int countWays(int[][] ranges) {
        // 方案数

        // 1. 交集合并
        // Cn2

        // 排序
        Arrays.sort(ranges, (a, b)-> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        ArrayDeque<int[]> stack = new ArrayDeque<>();

        for(int[] range : ranges){
            if (!stack.isEmpty() && (stack.peek()[1] >= range[0])){
               int[] arr = stack.poll();
               arr[1] = Math.max(range[1], arr[1]);

               stack.push(arr);
            }else{
                stack.push(range);
            }
        }


        // n个分成两组

        int n = stack.size();

        // n个分成两组
        int ans = 1;
        for(int i = 0; i < n; i++){
            ans = (2 * ans) %mode;
        }
        return ans;
    }


}
