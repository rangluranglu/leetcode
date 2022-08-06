package WeekCompetition.year2022.DW84;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class q6143 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3,1};
        System.out.println(taskSchedulerII(nums, 3));
    }
    public static long taskSchedulerII(int[] tasks, int space) {
        // 贪
        int n = tasks.length;
        long[] count = new long[n];

        long ans = n;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if(map.containsKey(tasks[i])){
                int lastIndex = map.get(tasks[i]);
                long step = 0L;
                while(lastIndex ++ < i){
                    step += count[lastIndex];
                }
                if(i - map.get(tasks[i]) - 1 + step < space){
                   count[i] = space - i + map.get(tasks[i]) + 1 - step;
                   ans += (space - i + map.get(tasks[i]) + 1 - step);
                }
                map.put(tasks[i], i);
            }else{
                map.put(tasks[i], i);
            }
        }

        System.out.println(Arrays.toString(count));

        return ans;

    }
}
