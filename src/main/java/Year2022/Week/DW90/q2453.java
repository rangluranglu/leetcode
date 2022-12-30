package Year2022.Week.DW90;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q2453 {
    public int destroyTargets(int[] nums, int space) {
        // 计算差值 为 space 的个数 ---> n * space

        // 周期为space

        // 对space 取余 ， 范围在[0, space - 1]
        Map<Integer, Integer> map = new HashMap<>();
        // 储存出现次数最多的次数
        List<Integer> list = new ArrayList<>();
        int maxNum = -1;
        for(int num : nums){
            int mod = num % space;
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }

        for(Integer key : map.keySet()){
            int curNum = map.get(key);
            if(curNum > maxNum){
                maxNum = curNum;
                list.clear();
                list.add(key);
            }else if(curNum == maxNum){
                list.add(key);
            }
        }


        int res = Integer.MAX_VALUE;
        for (int num : nums) {
            int mod = num % space;
            if (list.contains(mod) && num < res) res = num;
        }
        return res;

    }
}
