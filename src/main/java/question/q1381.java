package question;

public class q1381 {
}


class CustomStack {
    // 增量操作
    int[] stack;
    int top, maxSize;
    public CustomStack(int maxSize) {
        this.stack = new int[maxSize];
        top = 0;
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if(top <= maxSize - 1){
            stack[top ++] = x;
        }
    }

    public int pop() {
        return top >= 1 ? stack[--top] : -1;
    }

    public void increment(int k, int val) {
        for(int i = 0; i < Math.min(k, top); i++){
            stack[i] += val;
        }
    }
}
