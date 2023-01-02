package Year2023.Week.atemplate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class question2 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,4,3,7,10,6};
        System.out.println(distinctPrimeFactors(nums));
    }
    public static int distinctPrimeFactors(int[] nums) {
        // 质因子乘积
        Set<Integer> set = new HashSet<>();

        for(int nu : nums){
            // 对num
            int num = nu;
            for(int i = 2; i  <= num; i++){
                if(num % i == 0){
                    set.add(i);
                    while (num %i == 0){
                        num /= i;
                    }

                }
            }
        }

        return set.size();

    }
}
