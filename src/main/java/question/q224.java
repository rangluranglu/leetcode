package question;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class q224 {
    public int calculate(String s) {
        // 栈
        // 运算符栈
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(1);
        int sigh = 1;

        int ret = 0;
        int index = 0, n = s.length();

        while(index < n){
            char ch = s.charAt(index);
            switch (ch){
                case ' ':
                    index ++;
                    break;
                case '+':
                    sigh = stack.peek();
                    index ++;
                    break;
                case '-':
                    sigh = -stack.peek();
                    index++;
                    break;

                case '(':
                    stack.push(sigh);
                    index++;
                    break;

                case ')':
                    stack.pop();
                    index++;
                    break;

                default:
                    long num = 0;
                    while (index < n && Character.isDigit(s.charAt(index))){
                        num = num * 10 + s.charAt(index) - '0';
                        index ++;
                    }

                    ret += sigh * num;
                    break;

            }
        }
        return ret;


    }
}
