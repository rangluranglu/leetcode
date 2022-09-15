package question;

import java.util.Arrays;

public class q1658 {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        x = sum - x;

        if(x == 0){
            return n;
        }
        // 滑动窗口等于x的最长串长度
        int left = 0;
        int wSum = 0;
        int ans = -1;

        for(int right = 0; right < n; right++){
            wSum += nums[right];

            if(wSum == x){
                ans = Math.max(ans, right - left + 1);
            }

            while(right >= left && wSum > x){
                wSum -= nums[left];
                left ++;
                if(wSum == x){
                    ans = Math.max(ans, right - left + 1);
                }
            }
        }

        return ans == -1 ? -1 : n - ans;
    }
}
