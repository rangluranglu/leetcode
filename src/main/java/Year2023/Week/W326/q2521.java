package Year2023.Week.W326;

import java.util.HashSet;
import java.util.Set;

public class q2521 {
    public int distinctPrimeFactors(int[] nums) {
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
