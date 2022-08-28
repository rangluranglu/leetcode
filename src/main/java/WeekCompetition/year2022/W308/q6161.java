package WeekCompetition.year2022.W308;

import java.util.ArrayDeque;
import java.util.Deque;

public class q6161 {
    public String removeStars(String s) {

        Deque<Character> stack = new ArrayDeque<>();
        for(char ch : s.toCharArray()){
            if(ch == '*'){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pollLast());
        }

        return sb.toString();


    }
}
