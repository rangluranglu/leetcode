package Year2023.Week.atemplate;

public class q1 {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int ans = 0, n = nums.length;

        for (int i = 0; i < n; i++) {
            if(nums[i] % 2 == 0 && nums[i] <= threshold){
                int j = i;

                while (j < n - 1 && nums[j] <= threshold && nums[j +1] <= threshold && nums[j] % 2 != nums[j + 1] % 2){
                    j ++;
                }

                ans = Math.max(ans, j - i +1);
            }
        }

        return ans;
    }
}
