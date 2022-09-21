package question;

import java.util.*;
import java.util.stream.Collectors;

public class q752 {
    public int openLock(String[] deadends, String target) {
        // bfs
        if ("0000".equals(target)) {
            return 0;
        }

        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains("0000")) {
            return -1;
        }

        int step = 0;
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("0000");
        Set<String> visited = new HashSet<>();
        visited.add("0000");

        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String status = queue.poll();
                for (String next : get(status)) {
                    if (!visited.contains(next) && !dead.contains(next)) {
                        if (next.equals(target)) {
                            return step;
                        }

                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
        }

        return -1;
    }

    List<String> get(String status){
        List<String> ret = new ArrayList<>();
        char[] array = status.toCharArray();
        for (int i = 0; i < 4; i++) {
            char num = array[i];
            array[i] = numPrev(num);
            ret.add(new String(array));
            array[i] = numNext(num);
            ret.add(new String(array));

            array[i] = num;
        }

        return ret;
    }

    private char numPrev(char num){
        return num == '0' ? '9' : (char) (num - 1);
    }

    public char numNext(char num){
        return num == '9' ? '0' : (char) (num + 1);
    }

    public int openLock2(String[] deadends, String target) {
        // 启发式搜索
        if ("0000".equals(target)) {
            return 0;
        }

        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains("0000")) {
            return -1;
        }
        // 按照f排序
        PriorityQueue<Astar> pq = new PriorityQueue<>((a, b) -> a.f - b.f);
        pq.offer(new Astar("0000", target, 0));
        Set<String> visited = new HashSet<>();
        visited.add("0000");

        while (!pq.isEmpty()){
            Astar node = pq.poll();
            for(String nextStatus : get(node.status)){
                if(!visited.contains(nextStatus) && !dead.contains(nextStatus)){
                    if(nextStatus.equals(target)){
                        return node.g + 1;
                    }

                    pq.offer(new Astar(nextStatus, target, node.g + 1));
                    visited.add(nextStatus);
                }
            }
        }
        return -1;
    }

}

class Astar{
    String status;
    // f = g + h
    int f, g, h;

    public Astar(String status, String target, int g){
        this.status = status;
        this.g = g;
        this.h = getH(status, target);
        this.f = this.g + this.h;
    }

    // 计算H
    public static int getH(String status, String target){
        int ret = 0;
        for (int i = 0; i < 4; i++) {
            int dist = Math.abs(status.charAt(i) - target.charAt(i));
            ret += Math.min(dist, 10 - dist);
        }

        return ret;
    }

}
