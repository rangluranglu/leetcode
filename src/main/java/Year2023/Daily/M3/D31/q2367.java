package Year2023.Daily.M3.D31;

public class q2367 {
    public int arithmeticTriplets(int[] nums, int diff) {
        // nums[j] - nums[i] == diff || nums[k] - nums[j] == diff

        // 三指针
        int ans = 0;
        int n = nums.length;

        for(int i = 0, j = 1, k = 2; i < n - 2 && j < n - 1 && k < n; i++){
            j = Math.max(j, i + 1);
            while (j < n - 1 && nums[j] - nums[i] < diff){
                j ++;
            }

            if(j >= n - 1 || nums[j] - nums[i] > diff){
                continue;
            }

            k = Math.max(k, j + 1);
            while (k < n && nums[k] - nums[j] < diff){
                k ++;
            }

            if(k < n && nums[k] - nums[j] == diff){
                ans++;
            }
        }

        return ans;
    }
}
