package Year2022.Daily.M9.D26;

import java.util.Arrays;

public class interview1719 {
    public int[] missingTwo(int[] nums) {
        int len = nums.length;
        int n = len + 2;

        int sum = Arrays.stream(nums).sum();
        int resSum = (n * (n + 1) / 2) - sum;
        int m = resSum / 2;


        sum = 0;
        for(int i : nums){
            if(i <= m){
                sum += i;
            }
        }

        int res = (1 + m) * m / 2 - sum;
        return new int[]{res, resSum - res};

    }


    public int[] missingTwo2(int[] nums) {
        // 位运算
        int n = nums.length + 2;
        int res = 0;

        for (int i = 0; i <= n; i++) {
            res ^= i;
        }

        for(int i : nums){
            res ^= i;
        }

        int o = 0;
        int diff = res & -res;
        for(int i = 1; i <= n; i++){
            if((diff & i) != 0){
                o ^= i;
            }
        }

        for(int i : nums){
            if((diff & i) != 0){
                o ^= i;
            }
        }

        return new int[]{o, o ^ res};

    }
}
