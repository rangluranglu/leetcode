package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 插入区间
        int left = newInterval[0];
        int right = newInterval[1];
        boolean mergerd = false;
        List<int[]> ansList = new ArrayList<>();
        for(int[] interval : intervals){
            // 在右边并且没有交集
            if(interval[0] > right){
                if(!mergerd){
                    ansList.add(new int[]{left, right});
                    mergerd = true;
                }
                ansList.add(interval);
            }else if(left > interval[1]){
                // 在左边并且没有交集
                ansList.add(interval);
            }else {
                // 有交集，需要计算
                left = Math.min(interval[0], left);
                right = Math.max(interval[1], right);
            }
        }
        if(!mergerd){
            ansList.add(new int[]{left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }

        return ans;
    }
}
