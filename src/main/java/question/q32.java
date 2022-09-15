package question;

import java.util.ArrayDeque;
import java.util.Deque;

public class q32 {
    public int longestValidParentheses(String s) {
        // 最长有效括号

        int left = 0, right = 0;
        int ans = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                left ++;
            }else {
                right ++;
            }

            if(left == right){
                ans = Math.max(ans, 2 * right);
            }else if(right > left){
                left = right = 0;
            }
        }


        left = right = 0;
        for(int i = s.length() - 1; i >= 0; i --){
            if(s.charAt(i) == '('){
                left++;
            }else {
                right ++;
            }
            if(left == right){
                ans = Math.max(ans, 2 * right);
            }else if(left > right){
                left = right = 0;
            }
        }

        return ans;
    }


    public int longestValidParentheses2(String s) {
        // 栈
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }

        return ans;
    }
}
