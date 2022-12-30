package Year2022.Week.DW83;

public class q2348 {
    public static void main(String[] args) {
        int[] nums = new int[100000];
        System.out.println(zeroFilledSubarray(nums));
    }
    public static long zeroFilledSubarray(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        dp[0] = nums[0] == 0 ? 0 : 1;
        // dp 以i为结尾的 0 的子数组的数目
        long ans = 0;
        for(int i = 0; i < n;){

            while(i < n && nums[i] != 0){
                i ++;
            }
            // 找到第一 i 为 0;
            int count = 0;
            while (i < n && nums[i] == 0){
                i++;
                count ++;
            }


            ans += count != 0 ? ((long) count * (count + 1)) / 2 : 0;
        }

        return ans;

    }
}
