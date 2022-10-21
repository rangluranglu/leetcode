package WeekCompetition.year2022.W314;

import java.util.ArrayDeque;
import java.util.Deque;

public class q2434 {
    public String robotWithString(String S) {
        //
        Deque<Character> stack = new ArrayDeque<>();
        char[] leftMin = new char[S.length()];
        StringBuilder ans = new StringBuilder();
        for(int i = S.length() - 1; i >= 0; i--){
            if(i == S.length() - 1){
                leftMin[i] = 'z';
            }else{
                if(S.charAt(i + 1) < leftMin[i + 1]){
                    leftMin[i] = S.charAt(i + 1);
                }else{
                    leftMin[i] = leftMin[i + 1];
                }
            }
        }

        for(int i = 0; i < S.length(); i++){
            stack.push(S.charAt(i));
            while(!stack.isEmpty() && stack.peek() <= leftMin[i]){
                ans.append(stack.poll());
            }
        }

        return ans.toString();

    }
}
