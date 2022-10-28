package Daily.year2022.M10.D28;

import java.util.ArrayDeque;
import java.util.Deque;

public class q907 {
    public int sumSubarrayMins(int[] arr) {
        // 子数组
        // 单调栈
        int n = arr.length;
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] left = new int[n];
        int[] right = new int[n];

        // 左边第一个大于arr[i]的
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]){
                stack.pop();
            }

            left[i] = i - (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }

        stack.clear();

        // 右边第一个小于的
        for (int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                stack.pop();
            }
            right[i] = (stack.isEmpty() ? n : stack.peek()) - 1;
            stack.push(i);
        }

        int mod = (int) 1e9 + 7;
        for (int i = 0; i < n; i++) {
            ans = (ans + left[i] * right[i] * arr[i] % mod) % mod;
        }

        return ans;

    }
}
