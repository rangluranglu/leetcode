package Year2023.Week.W341;

public class q2644 {
    public int maxDivScore(int[] nums, int[] divisors) {
        // nums[j] 能被 divisors[i] 整除的数量

        // 暴力
        int ans = 0, ansDiv = Integer.MAX_VALUE;

        for(int div : divisors){
            int cnt = 0;

            for(int num : nums){

                if(num % div == 0){
                    cnt ++;
                }
            }

            if(cnt > ans){
                ans = cnt;
                ansDiv = div;
            }else if(cnt == ans){
                ansDiv = Math.min(ansDiv, div);
            }

        }

        return ansDiv;

    }
}
