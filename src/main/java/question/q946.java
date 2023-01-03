package question;

import java.util.ArrayDeque;
import java.util.Deque;

public class q946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 栈模拟
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0, j = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);

            while (!stack.isEmpty() && j < popped.length && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
