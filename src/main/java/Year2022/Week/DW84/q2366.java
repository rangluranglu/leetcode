package Year2022.Week.DW84;

public class q2366 {
    public static void main(String[] args) {
        int[] nums = {12,9,7,6,17,19,21};
        System.out.println(minimumReplacement(nums));
    }
    public static long minimumReplacement(int[] nums) {
        // 找递减序列最小值
        int n = nums.length;
        int tmp = nums[n - 1];

        long ans = 0L;

        for(int i = n - 2; i >= 0; i--){
            if(nums[i] <= tmp){
                tmp = nums[i];
            }else{
                // 向上取整
                int x = (nums[i]  - 1) / tmp + 1;
                int m = nums[i] / x;

                tmp = m;

                ans += (x  - 1);
            }
        }

        return ans;
    }
}
