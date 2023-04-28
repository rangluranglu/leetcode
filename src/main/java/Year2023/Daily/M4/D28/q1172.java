package Year2023.Daily.M4.D28;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class q1172 {
}

class DinnerPlates {

    // 数组模拟 + 有序集合
    // 用数组stack模拟栈， 编号为index 的栈的顶在数组的下标 index * capacity + stackTop.
    // 用有序集合 popedPos 保存删除的位置
    // 用拓扑记录每个栈的栈顶

    int capacity;
    List<Integer> stack;
    List<Integer> top;
    TreeSet<Integer> popedPos;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        stack = new ArrayList<>();
        top = new ArrayList<>();   //top的长度就是栈的长度
        popedPos = new TreeSet<>();


    }

    // 正整数推入从左往右的第一的没有满的栈
    public void push(int val) {
        if(popedPos.isEmpty()){
            // 还没有元素弹出
            int pos = stack.size();
            stack.add(val);

            if(pos % capacity == 0){
                top.add(0);
            }else {
                int stackPos = top.size() - 1;
                int stackTop = top.get(stackPos);
                top.set(stackPos, stackTop + 1);
            }
        }else {
            int pos = popedPos.pollFirst();
            stack.set(pos, val);

            int index = pos / capacity;
            int stackTop = top.get(index);
            top.set(index, stackTop + 1);
        }
    }

    // 返回 从右往左第一个 非空栈顶部的值，并将其从栈中删除；如果所有的栈都是空的，请返回 -1。
    public int pop() {
        // 弹出
        while (!stack.isEmpty() && popedPos.contains(stack.size() - 1)){
            stack.remove(stack.size() - 1);

            int pos = popedPos.pollLast();
            if(pos % capacity == 0){
                top.remove(top.size() - 1);
            }
        }

        if(stack.isEmpty()){
            return -1;
        }else {

            int pos = stack.size() - 1;
            int val = stack.get(pos);
            stack.remove(pos);

            int index = top.size() - 1;
            if(pos % capacity == 0){
                top.remove(index);
            }else {
                top.set(index, index - 1);
            }

            return val;
        }
    }

    public int popAtStack(int index) {
        if(index >= top.size()){
            return -1;
        }

        int stackTop = top.get(index);

        if(stackTop < 0){
            return -1;
        }

        top.set(index, stackTop - 1);
        int pos = index * capacity + stackTop;

        popedPos.add(pos);
        return stack.get(pos);
    }
}

