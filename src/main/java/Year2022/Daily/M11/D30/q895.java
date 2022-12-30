package Year2022.Daily.M11.D30;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class q895 {
}

class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Deque<Integer>> group;

    private int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;

    }

    public void push(int val) {
        freq.put(val, freq.getOrDefault(val, 0) + 1);
        group.putIfAbsent(freq.get(val), new ArrayDeque<>());
        group.get(freq.get(val)).push(val);

        maxFreq = Math.max(maxFreq, freq.get(val));
    }

    public int pop() {
        // 取出最大频率的元素
        int val = group.get(maxFreq).pop();

        // 跟新频率
        freq.put(val, freq.get(val) - 1);

        // maxFra -1 一定是有值的
        if(group.get(maxFreq).isEmpty()){
            maxFreq --;
        }

        return val;
    }
}
