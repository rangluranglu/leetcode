package Year2022.Daily.M11.D5;

import java.util.ArrayDeque;

public class q1106 {
    public boolean parseBoolExpr(String expression) {
        // 用两个栈模拟
        ArrayDeque<Character> stackOperand = new ArrayDeque<>();
        ArrayDeque<Character> stackOperator = new ArrayDeque<>();

        char[] chars = expression.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == 't'  || chars[i] == 'f' || chars[i] == '('){
                stackOperand.push(chars[i]);
            }else if(chars[i] == '|'  || chars[i] == '&' || chars[i] == '!'){
                stackOperator.push(chars[i]);
            }else if(chars[i] == ')'){
                // 结束一个表达式
                int trueCount = 0, falseCount = 0;
                char operator = stackOperator.pop();

                while(!stackOperand.isEmpty() && stackOperand.peek() != '('){
                    char pop = stackOperand.pop();

                    if(pop == 't'){
                        trueCount ++;
                    }else{
                        falseCount ++;
                    }
                }

                if(!stackOperand.isEmpty() && stackOperand.peek() == '('){
                    stackOperand.pop();
                }

                if(operator == '!'){
                    stackOperand.push(trueCount == 0 ? 't' : 'f');
                }else if(operator == '&'){
                    stackOperand.push(falseCount > 0 ? 'f' : 't');
                }else{
                    stackOperand.push(trueCount > 0 ? 't' : 'f');
                }
            }
        }

        return stackOperand.pop() == 't';

    }
}
