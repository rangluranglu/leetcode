package Year2023.Daily.M1.D14;

import java.util.Arrays;

public class q1819 {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        // 枚举
        // 枚举非空子序列中不同的最大公约数的数目
        // p 是一个序列的最大公约数， 令ai = ci * p
        int maxVal = Arrays.stream(nums).max().getAsInt();
        // 枚举最大公约数
        boolean[] occured = new boolean[maxVal + 1];

        for (int num : nums) {
            occured[num] = true;
        }

        // 枚举最大公约数
        int ans = 0;
        for (int i = 1; i <= maxVal; i++) {
            int subGcd = 0;
            for(int j = i; j <= maxVal; j += i){
                if(occured[j]){
                    if(subGcd == 0){
                        subGcd = j;
                    }else {
                        subGcd = gcd(subGcd, j);
                    }

                    if(subGcd == i){
                        ans ++;
                        break;
                    }
                }
            }
        }
        return ans;
    }


    public int gcd(int num1, int num2){
        while (num2 != 0){
            int tmp = num1;
            num1 = num2;
            num2 = tmp % num2;
        }

        return num1;
    }
}
