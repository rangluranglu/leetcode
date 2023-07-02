package Year2023.Week.atemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q2 {

    public static int[] primes;
    static int n1 = 10000001;
    static {
        primes = new int[n1];

        Arrays.fill(primes, 1);
        primes[0] = primes[1] = 0;
        int ans = 0;
        // 质数筛；
        for(int i = 2; i < n1; i++){
            if(primes[i] == 1){
                ans ++;
                if((long) i * i < n1){
                    for(int j = i * i; j < n1; j += i){
                        primes[j] = 0;
                    }
                }
            }
        }
    }
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i <= n/2; i ++){
            if(primes[i] == 1 && primes[n - i] == 1){
                List<Integer> p = new ArrayList<>();
                p.add(i);
                p.add(n - i);
                ans.add(p);
            }
        }

        return ans;
    }
}
