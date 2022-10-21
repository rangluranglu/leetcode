package Daily.year2022.M10.D21;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class q901 {

}
class StockSpanner {
    List<Integer> list;

    // 单调栈
    Deque<Integer> stack;
    int index;
    public StockSpanner() {
        list = new ArrayList<>();
        stack = new ArrayDeque<>();
        index = 0;
    }

    public int next(int price) {
        while (!stack.isEmpty() && price > list.get(stack.peek())){
            stack.pop();
        }
        int ans;
        if(stack.isEmpty()){
            ans = index + 1;
        }else{
            ans = index - stack.peek();
        }

        stack.push(index);
        list.add(price);
        index ++;
        return ans;
    }
}