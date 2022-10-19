package question;

import java.util.*;

public class q1834 {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        List<Integer> idx = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            idx.add(i);
        }
        // 按时间顺序排序任务
        Collections.sort(idx, (a, b) -> tasks[a][0] - tasks[b][0]);
        // 优先队列存储任务队列 a[0] 时间 ， a[1] 下标；
        Queue<int[]> heap = new PriorityQueue<>((o1, o2) -> {
            return  o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
        });

        int[] res = new int[n];
        // k 数组指针， time 时间戳
        int k = 0, time = 0;
        for (int i = 0; i < n; i++){
            // 没有可执行任务， 快进
            if(heap.isEmpty()){
                time = Math.max(time, tasks[idx.get(k)][0]);
            }

            // 将所有小于时间戳的任务放入优先队列
            while(k < n && tasks[idx.get(k)][0] <= time){
                heap.offer(new int[]{tasks[idx.get(k)][1], idx.get(k)});
                k ++;
            }

            // 处理时间最小的任务
            int[] t = heap.poll();
            time += t[0];
            res[i] = t[1];
        }

        return res;
    }
}
