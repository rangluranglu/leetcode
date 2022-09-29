package question;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class q84 {
    public int largestRectangleArea(int[] heights) {
        // 单调栈
        // 找左侧且最近的小于其高度的柱子, 这两根柱子之间（不包括其本身）的所有柱子高度均不小于 h
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        // 单调递增的单调栈
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();;
        for (int i = n - 1; i >= 0; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }

        return ans;
    }

    public int largestRectangleArea2(int[] heights) {
        // 单调栈
        // 找左侧且最近的小于其高度的柱子, 这两根柱子之间（不包括其本身）的所有柱子高度均不小于 h
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        // 单调递增的单调栈
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                right[stack.peek()] = i;
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }

        return ans;
    }
}
