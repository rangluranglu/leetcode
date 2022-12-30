package Year2022.Daily.M8.D13;

import java.util.ArrayDeque;
import java.util.Deque;

public class q768 {
    public int maxChunksToSorted(int[] arr) {
        // 单调栈
        Deque<Integer> stack = new ArrayDeque<>();

        for(int num : arr){
            if(stack.isEmpty() || num >= stack.peek()){
                stack.push(num);
            }else{
                int mx = stack.pop();

                while(!stack.isEmpty() && stack.peek() > num){
                    stack.pop();
                }

                stack.push(mx);
            }
        }

        return stack.size();
    }
}
