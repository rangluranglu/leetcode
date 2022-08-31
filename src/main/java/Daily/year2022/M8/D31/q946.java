package Daily.year2022.M8.D31;

import java.util.ArrayDeque;
import java.util.Deque;

public class q946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int j = 0;
        for(int i = 0; i < n; i++){
            stack.push(pushed[i]);
            while(j < n && !stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }
}
