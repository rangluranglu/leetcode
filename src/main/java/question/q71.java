package question;

import java.util.ArrayDeque;
import java.util.Deque;

public class q71 {
    public String simplifyPath(String path) {
        // 简化路径 --> 栈
        // 分割path

        Deque<String> stack = new ArrayDeque<>();
        int n = path.length();
        String[] names = path.split("/");

        for(String name : names){
            if("..".equals(name)){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else if (name.length() > 0 && !".".equals(name)) {
                stack.offer(name);
            }
        }

        StringBuilder sb = new StringBuilder("/");
        while (!stack.isEmpty()){
            sb.append(stack.pollLast());
            if(!stack.isEmpty()){
                sb.append("/");
            }

        }

        return sb.toString();



    }
}
