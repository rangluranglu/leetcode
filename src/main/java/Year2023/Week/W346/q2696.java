package Year2023.Week.W346;

import java.util.ArrayDeque;
import java.util.Deque;

public class q2696 {
    public int minLength(String s) {
        // 栈

        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()){
            if(c == 'B' && !stack.isEmpty() && stack.peek() == 'A'){
                stack.pop();
            }else if(c == 'D' && !stack.isEmpty() && stack.peek() == 'C'){
                stack.pop();
            }else {
                stack.push(c);
            }
        }

        return stack.size();
    }
}
