package Year2023.Daily.M3.D7;

import java.util.*;

public class q1096 {
    public List<String> braceExpansionII(String expression) {
        // 栈

        // 操作符合栈
        Deque<Character> op = new ArrayDeque<>();
        // 操作栈
        List<Set<String>> stk = new ArrayList<>();


        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if(c == ','){
                // 如果是 * 需要先计算乘法
                while (!op.isEmpty() && op.peek() == '*'){
                    ope(op, stk);
                }
                op.push('+');
            }else if(c == '{'){
                // 判断是否需要添加乘号
                if(i > 0 && (expression.charAt(i - 1) == '}' || Character.isLetter(expression.charAt(i - 1)))){
                    op.push('*');
                }
                op.push('{');
            }else if(c == '}'){
                while (!op.isEmpty() && op.peek() != '{'){
                    ope(op, stk);
                }
                op.pop();
            }else {
                // 判断是否需要添加乘号
                if(i > 0 && (expression.charAt(i - 1) == '}' || Character.isLetter(expression.charAt(i - 1)))){
                    op.push('*');
                }

                StringBuilder sb = new StringBuilder();
                sb.append(expression.charAt(i));
                stk.add(new TreeSet<String>(){{
                    add(sb.toString());
                }});
            }
        }

        while (!op.isEmpty()){
            ope(op, stk);
        }

        return new ArrayList<>(stk.get(stk.size() - 1));
    }

    public void ope(Deque<Character> op, List<Set<String>> stk){
        // 弹出栈顶的运算符，并计算
        int l = stk.size() - 2, r = stk.size() - 1;

        if(op.peek() == '+'){
            // 是+
            stk.get(l).addAll(stk.get(r));
        }else {
            Set<String> tmp = new TreeSet<>();
            for(String left : stk.get(l)){
                for(String right : stk.get(r)){
                    tmp.add(left + right);
                }
            }
            stk.set(l, tmp);
        }

        op.pop();
        stk.remove(stk.size() - 1);
    }
}
