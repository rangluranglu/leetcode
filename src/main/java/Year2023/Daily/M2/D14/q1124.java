package Year2023.Daily.M2.D14;

import java.util.ArrayDeque;
import java.util.Deque;

public class q1124 {
    public int longestWPI(int[] hours) {
        // >= 8 > <8 的天数

        // 滑动窗口 简单的不太行， 因为是最大长度
        // 贪心 计算前缀和
        // 求 l, r 使 s[r] - s[l] > 0;

        int n = hours.length;
        int[] s = new int[n + 1];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
            if(s[stack.peek()] > s[i]){
                stack.push(i);
            }
        }

        int ans = 0;
        for(int r = n; r >= 1; r--){
            while (!stack.isEmpty() && s[stack.peek()] < s[r]){
                ans = Math.max(ans, r - stack.pop());
            }
        }

        return ans;
    }
}
