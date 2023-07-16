package Year2023.Daily.M7.D15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            // 枚举b
            for(int j = i + 1; j < n; j ++){
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }

                // 双指针找c,d
                long t = nums[i] + nums[j];

                int k = j + 1, l = n - 1;

                while (k < l){
                    if(k > j + 1 && nums[k] == nums[k - 1]){
                        k++;
                        continue;
                    }

                    if(l < n - 1 && nums[l] == nums[l + 1]){
                        l --;
                        continue;
                    }
                    int sum = nums[k] + nums[l];
                    if(sum + t == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        ans.add(list);
                        k ++;
                        l --;
                    }else if(sum + t < target){
                        k ++;
                    }else {
                        l --;
                    }
                }

            }
        }

        return ans;
    }
}
