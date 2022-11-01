package question;

import java.util.ArrayDeque;
import java.util.Deque;

public class q1106 {
    public boolean parseBoolExpr(String expression) {
        // 两个栈分别记录
        ArrayDeque<Character> stackOperand = new ArrayDeque<>();
        ArrayDeque<Character> stackOperator = new ArrayDeque<>();

        char[] chars = expression.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == 't' || chars[i] == 'f' || chars[i] == '('){
                stackOperand.push(chars[i]);
            }else if(chars[i] == '|' || chars[i] == '&' || chars[i] == '!'){
                stackOperator.push(chars[i]);
            }else if(chars[i] == ')'){
                int tureCount = 0;
                int falseCount = 0;
                char operator = stackOperator.pop();
                while(!stackOperand.isEmpty()){
                    char pop = stackOperand.pop();
                    if(pop == 't'){
                        tureCount ++;
                    }else if(pop == 'f'){
                        falseCount ++;
                    }else if(pop == '('){
                        break;
                    }
                }

                if(operator == '!'){
                    stackOperand.push(tureCount == 0 ? 't' : 'f');
                }else if(operator == '&'){
                    stackOperand.push(falseCount > 0 ? 'f' : 't');
                }else if(operator == '|'){
                    stackOperand.push(tureCount > 0 ? 't' : 'f');
                }
            }
        }
        return stackOperand.pop() == 't';
    }
}
