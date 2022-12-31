package question;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class q1249 {
    public String minRemoveToMakeValid(String s) {
        // 栈 和 stringBuilder

        Set<Integer> indexesToRemove = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();

        int n = s.length();
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '('){
                stack.push(i);
            }else if(s.charAt(i) == ')'){
                if(stack.isEmpty()){
                    indexesToRemove.add(i);
                }else {
                    stack.pop();
                }
            }
        }

        //
        while (!stack.isEmpty()){
            indexesToRemove.add(stack.peek());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(!indexesToRemove.contains(i)){
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }



    public String minRemoveToMakeValid2(String s) {
        // 栈 和 stringBuilder

        StringBuilder sb = new StringBuilder();

        int n = s.length();
        int balance = 0;
        int left = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == '('){
                balance ++;
                left ++;
            }else if(c == ')'){
                if(balance == 0){
                    continue;
                }
                balance --;
            }
            sb.append(c);
        }

        // 去掉 (

        StringBuilder ans = new StringBuilder();
        // 需要保留的个数
        int res = left - balance;

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if(c == '('){
                res --;
                if(res < 0){
                    continue;
                }
            }

            ans.append(sb.charAt(i));
        }

        return ans.toString();
    }
}
