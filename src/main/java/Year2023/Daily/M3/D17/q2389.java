package Year2023.Daily.M3.D17;

import java.util.Arrays;

public class q2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
        // 子序列
        // 前缀和 + 二分
        Arrays.sort(nums);
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int[] ans = new int[queries.length];

        for(int i = 0; i < queries.length; i++){
            ans[i] = search(preSum, queries[i]) - 1;
        }

        return ans;
    }

    public int search(int[] preSum, int target){
        // 找到第一个 大于 target 的坐标
        int left = 0, right = preSum.length - 1;

        while (left <= right){
            int mid = left + (right - left) / 2;

            if(preSum[mid] < target){
                left = mid + 1;
            }else if(preSum[mid] == target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return left;
    }
}
