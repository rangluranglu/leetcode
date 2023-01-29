package Year2023.Daily.M1.D28;

public class q1664 {
    public int waysToMakeFair(int[] nums) {
        // 方案数 动态规划
        int odd1 = 0, even1 = 0;
        int odd2 = 0, even2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if((i & 1) == 0){
                even2 += nums[i];
            }else {
                odd2 += nums[i];
            }
        }

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            // 枚举
            if((i & 1) != 0){
                // 奇数
                odd2 -= nums[i];
            }else{
                even2 -= nums[i];
            }

            if(odd1 + even2 == odd2 + even1){
                ans ++;
            }

            if((i & 1) != 0){
                // 奇数
                odd1 += nums[i];
            }else{
                even1 += nums[i];
            }
        }

        return ans;
    }
}
