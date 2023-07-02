package Year2023.Week.W351;

import java.util.*;
import java.util.stream.Collectors;

public class question4 {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        // 分别维护向左和向右的机器人
        // 按照 positions 排序

        int n = positions.length;
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        // 排序
        Arrays.sort(index, (a, b) -> positions[a] - positions[b]);
        System.out.println(Arrays.toString(index));
        Deque<Integer> left = new ArrayDeque<>(), right = new ArrayDeque<>();
        next:
        for(int idx : index){
            // 遍历下标,如果向右
            if(directions.charAt(idx) == 'R'){
                // 向右
                right.push(idx);
                continue next;
            }

            // 机器人向左, 是否与向右机器人碰撞
            while (!right.isEmpty()){
                // 向右
                int peek = right.peek();
                if(healths[peek] > healths[idx]){
                    // 栈顶更健康, 已经销毁，可以遍历下一个元素
                    healths[peek] -= 1;
                    continue  next;
                }
                    // 已经销毁
                if(healths[peek] == healths[idx]){
                    // 一样健康
                    right.pop();
                    continue next;
                }
                // 当前更健康
                healths[idx] -= 1;
                right.pop();
            }
            // 当前元素可以全撞掉
            left.push(idx);
        }
        // 合并剩余机器
        while (!right.isEmpty()){
            left.push(right.poll());
        }

        List<Integer> collect = left.stream().sorted().map(a -> healths[a]).collect(Collectors.toList());
        return collect;


    }
}
