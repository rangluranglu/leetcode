package Year2023.Daily.M7.D18;

import java.util.Arrays;
import java.util.PriorityQueue;

public class q1851 {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // 排序， 优先队列

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[][] que = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            que[i][0] = queries[i];
            que[i][1] = i;
        }

        // 排序
        Arrays.sort(que, (a, b) -> a[0] - b[0]);
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);

        // 优先队列
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - a[0] - b[1] + b[0]);
        int index = 0;

        for (int i = 0; i < queries.length; i++) {
            // 加入区间左边界小于等于queries[i]的区间加入
            while (index < intervals.length && intervals[index][0] <= que[i][0]) {
                queue.offer(intervals[index]);
                index++;
            }

            // 删除区间右边界小于queries[i]的区间
            while(!queue.isEmpty() && queue.peek()[1] < que[i][0]){
                queue.poll();
            }

            if(!queue.isEmpty()){
                int[] t = queue.peek();
                ans[que[i][1]] = t[1] - t[0] + 1;
            }
        }
        return ans;
    }

    public int[] minInterval2(int[][] intervals, int[] queries) {
        // 排序， 优先队列

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[][] que = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            que[i][0] = queries[i];
            que[i][1] = i;
        }

        // 排序
        Arrays.sort(que, (a, b) -> a[0] - b[0]);
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);

        // 优先队列
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int i = 0;

        for(int[] q : que){
            while (i < intervals.length && intervals[i][0] <= q[0]){
                int a = intervals[i][0], b = intervals[i][1];
                queue.offer(new int[]{b - a + 1, b});
            }

            while (!queue.isEmpty() && queue.peek()[1] < q[0]){
                queue.poll();
            }
            if(!queue.isEmpty()){
                ans[q[1]] = queue.peek()[0];
            }
        }

        return ans;

    }
}
