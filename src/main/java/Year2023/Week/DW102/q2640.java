package Year2023.Week.DW102;

public class q2640 {
    public long[] findPrefixScore(int[] nums) {
        int n = nums.length;

        long preMx = 0;

        long[] ans = new long[n];

        for (int i = 0; i < n; i++) {
            preMx = Math.max(preMx, nums[i]);
            if(i == 0){
                ans[i] = preMx + nums[i];
            }else{
                ans[i] = ans[i - 1] + preMx + nums[i];
            }
        }

        return ans;

    }
}
