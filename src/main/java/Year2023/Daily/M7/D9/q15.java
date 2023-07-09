package Year2023.Daily.M7.D9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            // 枚举后两个
            int k = n - 1, target = -nums[i];

            for(int j = i + 1; j < n; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }

                while (j < k && nums[j] + nums[k] > target){
                    k --;
                }

                if(j == k){
                    break;
                }

                if(nums[j] + nums[k] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
