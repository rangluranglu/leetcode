package Year2022.Week.W315;

import java.util.HashSet;
import java.util.Set;

public class q2442 {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            // 问题？
            if(set.add(num)){
                // 添加成功
                set.add(reverse(num));
            }
        }

        return set.size();
    }

    private int reverse(int sum){
        StringBuilder sb = new StringBuilder(String.valueOf(sum));
        return Integer.parseInt(sb.reverse().toString());
    }
}
