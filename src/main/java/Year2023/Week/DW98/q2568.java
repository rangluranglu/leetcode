package Year2023.Week.DW98;

import java.util.HashSet;
import java.util.Set;

public class q2568 {
    public int minImpossibleOR(int[] nums) {
        // 可表达， 子序列 或值最小非零   或 可以让 0--> 1 不可以 1-->0
        // 最小
        Set<Integer> set = new HashSet<>();
        for(int x : nums) {
            set.add(x);
        }


        for(int i = 1; ; i <<= 1){
            if(!set.contains(i)){
                return i;
            }
        }


    }
}
