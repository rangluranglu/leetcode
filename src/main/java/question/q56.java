package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        // 排序，start 递增， end 递减
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? (b[1] - a[1]) : a[0] - b[0]);

        // 开始合并
        for(int[] interval : intervals){
            if(ans.size() == 0){
                ans.add(interval);
                continue;
            }

            int[] node = ans.get(ans.size() - 1);

            if(node[1] >= interval[0]){
                node[1] = Math.max(node[1], interval[1]);
            }else{
                ans.add(interval);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
