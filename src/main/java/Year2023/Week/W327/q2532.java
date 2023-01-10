package Year2023.Week.W327;

import java.util.Arrays;
import java.util.PriorityQueue;

public class q2532 {
    public int findCrossingTime(int n, int k, int[][] time) {
        // 模拟
        // 建立四个堆，分别保存
        // workL: 新仓库正在放箱子的工人
        // waitL: 左边等待过桥的工人
        // waitR : 右边等待过桥的工人
        // workR: 旧仓库正在搬箱的工人

        // 记录当前时间cur， 不断循环
        // 1. 完成时间不超过 cur 的 workL 弹出， 放入 waitL
        // 2. 完成时间不超过 cur 的 workR 弹出， 放入 waitR
        // 3. 如果waitR 不为空，出堆，过桥，更新cur为过完桥时间，把工人放入workL中，
        // 4. 如果waitL 不为空，出堆，过桥，更新cur为过完桥时间，把工人放入workR中 ，同时 n - 1
        // 5. 否则说明cur过小，找个最小的放箱/搬箱完成时间来更新cur

        Arrays.sort(time, (a, b) -> a[0] + a[2] - b[0] - b[2]); // 排序
        // 左到右 , 从旧仓库选择箱子返回桥边, 右到左, 箱子放入新仓库回到桥边

        // 存放， (工人的序号， 到达桥边的时间)
        PriorityQueue<int[]> workL = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        //
        PriorityQueue<int[]> workR = new PriorityQueue<>(workL.comparator());

        // (工人序号， 结束时间)
        PriorityQueue<int[]> waitL = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> waitR = new PriorityQueue<>(waitL.comparator());

        for (int i = k - 1; i >= 0; i--){
            waitL.add(new int[]{i, 0});
        }

        int cur = 0;
        while (n > 0){
            while (!workL.isEmpty() && workL.peek()[1] <= cur){
                waitL.add(workL.poll());
            }

            while (!workR.isEmpty() && workR.peek()[1] <= cur){
                waitR.add(workR.poll());
            }

            if(!waitR.isEmpty()){
                // 右边过桥，注意加到waitR 中都是 <= cur 的
                int[] p = waitR.poll();
                cur += time[p[0]][2];
                p[1] = cur + time[p[0]][3];
                workL.add(p);
            }else if(!waitL.isEmpty()){
                int[] p = waitL.poll();
                cur += time[p[0]][0];
                p[1] = cur + time[p[0]][1];
                workR.add(p);
                n--;
            }else if(workL.isEmpty()){
                cur = workR.peek()[1];
            }else if(workR.isEmpty()){
                cur = workL.peek()[1];
            }else{
                cur = Math.min(workL.peek()[1], workR.peek()[1]);
            }
        }

        while (!workR.isEmpty()){
            int[] p = workR.poll();
            // 如果没有排队，直接过桥；否则由于无论谁先过桥，最终完成时间都一样，所以也可以直接计算
            cur = Math.max(p[1], cur) + time[p[0]][2];
        }

        return cur;

    }
}
