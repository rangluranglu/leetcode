package Year2023.Daily.M7.D23;

import java.util.ArrayDeque;
import java.util.Deque;

public class q42 {
    public int trap(int[] height) {
        // 接雨水
        // 单调栈
        int ans = 0;
        int n = height.length;
        int[] maxLeft = new int[n];
        maxLeft[0] = 0;
        for(int i = 1; i < n; i++){
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }

        System.out.println(maxLeft);
        int maxRight = height[n - 1];
        for(int i = n - 2; i >= 0;  i --){
            if(maxRight > height[i] && maxLeft[i] > height[i]){
                ans += Math.min(maxRight, maxLeft[i]) - height[i];

            }


            maxRight = Math.max(maxRight, height[i]);
        }

        return ans;
    }


    public int trap2(int[] height) {
        // 接雨水
        // 刷指针
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;

        while (left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if(height[left] < height[right]){
                // 必有 leftMax < rightMax
                ans += leftMax - height[left];
                left++;
            }else{
                ans += rightMax - height[right];
                right--;
            }
        }

        return ans;
    }
}
