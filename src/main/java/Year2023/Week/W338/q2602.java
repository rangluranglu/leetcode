package Year2023.Week.W338;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q2602 {
    public List<Long> minOperations(int[] nums, int[] queries) {
        // 前缀和 + 二分

        Arrays.sort(nums);
        int n = nums.length;

        long[] preSum = new long[n + 1];  //前缀和

        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        List<Long> ans = new ArrayList<>(queries.length);

        for(int q : queries){
            // 找到大于等于q的第一个坐标
            int j = lowerBound(nums, q);

            long left = (long) q * j - preSum[j];
            long right = preSum[n] - preSum[j]- (long) q * (n - j);

            ans.add(left + right);
        }
        return ans;
    }

    private int lowerBound(int[] nums, int target){
        int left = 0, right = nums.length - 1;

        while (left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else {
                return mid;
            }
        }

        return left;
    }
}
