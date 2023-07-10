package Year2023.Daily.M7.D10;

import java.util.Arrays;

public class q16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        // 3 <= n <= 1000
        int ans = Integer.MAX_VALUE, mn = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            for(int j = i + 1; j < n; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }

                // 找k
                int k = j + 1;
                while (k < n ){
                    if(Math.abs(nums[i] + nums[j] + nums[k] - target)  < mn){
                        mn = Math.abs(nums[i] + nums[j] + nums[k] - target);
                        ans = nums[i] + nums[j] + nums[k];
                    }
                    k ++;
                }
            }
        }
        return ans;
    }

    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        // 3 <= n <= 1000
        int ans = Integer.MAX_VALUE, mn = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            // 加入优化
            if(i + 2 < n && nums[i] + nums[i + 1] + nums[i + 2] > target){
                if(nums[i] + nums[i + 1] + nums[i + 2] - target < mn){
                    mn = nums[i] + nums[i + 1] + nums[i + 2] - target;
                    ans = nums[i] + nums[i + 1] + nums[i + 2];
                }
                break;
            }


            if(i < n - 2 && nums[i] + nums[n - 1] + nums[n - 2] < target){
                if(target - nums[i] - nums[n - 1] - nums[n - 2] < mn){
                    mn = target - nums[i] - nums[n - 1] - nums[n - 2];
                    ans = nums[i] + nums[n - 1] + nums[n - 2];
                }
                continue;
            }

            // 使用双指针枚举j, k
            int j = i + 1, k = n - 1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    return sum;
                }

                if(Math.abs(target - sum) < mn){
                    ans = sum;
                    mn = Math.abs(target - sum);
                }


                if(sum > target){
                    while (j < k && nums[k] == nums[k - 1]){
                        k --;
                    }
                    k --;
                }else{
                    while (j < k && nums[j] == nums[j + 1]){
                        j ++;
                    }
                    j++;
                }
            }
        }
        return ans;
    }
}
