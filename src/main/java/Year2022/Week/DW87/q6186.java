package Year2022.Week.DW87;

public class q6186 {
    public int[] smallestSubarrays(int[] nums) {
        // 前缀和
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = 1;
            for(int j = i - 1; j >= 0 && (nums[j] | nums[i]) != nums[j]; j--){
                nums[j] |= nums[i];
                ans[j] = i - j + 1;
            }
        }
        return ans;
    }
}
