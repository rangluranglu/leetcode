package Year2023.Week.W351;

import java.util.*;

public class question1 {

    public int countBeautifulPairs(int[] nums) {
        // 长度为100
        int[][] newNums = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            newNums[i][1] = nums[i] % 10;
            while (nums[i] / 10 != 0){
                nums[i] /= 10;
            }
            newNums[i][0] = nums[i];
        }
        System.out.println(Arrays.deepToString(newNums));
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++){
                if(gcd(newNums[i][0], newNums[j][1]) == 1){
                    System.out.println("index i" + i + " index j " + j);
                    ans ++;
                }
            }
        }

        return ans;
    }

    private int gcd(int a, int b){
        if(a == 1 || b == 1){
            return 1;
        }
        while (b != 0){
            int tmp = a;
            a = b;
            b = tmp % a;
        }

        return a;

    }

}
