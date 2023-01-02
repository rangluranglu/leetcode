package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q204 {
    public int countPrimes(int n) {
        // 返回所有小于非负数n 的质数的数量

        // 埃氏筛
        // 算法由希腊数学家厄拉多塞（Eratosthenes\rm EratosthenesEratosthenes）提出，称为厄拉多塞筛法，简称埃氏筛。
        // 如果 x 是质数，那么大于 x 的 x 的倍数 2x,3x,… 一定不是质数，因此我们可以从这里入手。

        // 时间复制度： O(n log log n)
        // 空间复制度： O(n)

        int[] isPrime = new int[n];

        Arrays.fill(isPrime, 1);

        int ans = 0;

        for(int i = 2; i < n; i++){
            if(isPrime[i] == 1){
                ans += 1;

                if((long) i * i < n){
                    for(int j = i * i; j < n; j += i){
                        isPrime[j] = 0;
                    }
                }
            }
        }

        return ans;



    }


    public int countPrimes2(int n) {
        // 返回所有小于非负数n 的质数的数量

        // 线性筛， 埃氏筛其实还是存在冗余的标记操作，比如对于 45 这个数，它会同时被 3,5 两个数标记为合数，因此我们优化的目标是让每个合数只被标记一次，这样时间复杂度即能保证为 O(n)，这就是我们接下来要介绍的线性筛。
        // 相较于埃氏筛，我们多维护一个 primes 数组表示当前得到的质数集合。我们从小到大遍历，如果当前的数 xxx 是质数，就将其加入 primes 数组。


        List<Integer> primes = new ArrayList<>();
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);

        for(int i = 2; i < n; i++){
            if(isPrime[i] == 1){
                primes.add(i);
            }

            for(int j = 0; j < primes.size() && i * primes.get(j) < n; j++){
                isPrime[i * primes.get(j)] = 0;
                if(i % primes.get(j) == 0){
                    break;
                }
            }


        }
        return primes.size();
    }
}
