package Year2022.Week.DW83;

import java.util.*;

public class q2349 {

}
class NumberContainers {
    Map<Integer, Integer> m = new HashMap<>();
    Map<Integer, Queue<Integer>> ms = new HashMap<>();

    public void change(int index, int number) {
        m.put(index, number);
        ms.computeIfAbsent(number, k -> new PriorityQueue<>()).offer(index);
    }

    public int find(int number) {
        Queue<Integer> q = ms.get(number);
        if (q == null) return -1;
        while (!q.isEmpty() && m.get(q.peek()) != number) q.poll();
        return q.isEmpty() ? -1 : q.peek();
    }
}
