package question;

import java.util.ArrayDeque;
import java.util.Deque;

public class q42 {

    public int trap(int[] height) {
        // 记录左右边的最大值
        int n = height.length;
        if(n == 0){
            return 0;
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return ans;

    }

    public int trap2(int[] height) {
        // 单调栈：递减

        int n = height.length;
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                int top = stack.pop();

                if(stack.isEmpty()){
                    break;
                }

                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i])  - height[top];

                ans += currWidth * currHeight;
            }

            stack.push(i);
        }

        return ans;
    }


    public int trap3(int[] height) {
        // 双指针

        int n = height.length;
        int ans = 0;
        int left = 0, right = n -1;
        int leftMax = 0, rightMax =0;

        while (left < right){
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);

            if(height[left] < height[right]){
                // height[left] < height[right]有 leftMax < rightMax --> leftMax <= height[left] < rightMax
                ans += leftMax - height[left];
                left ++;
            }else {
                ans += rightMax - height[right];
                right --;
            }
        }

        return ans;
    }
}
