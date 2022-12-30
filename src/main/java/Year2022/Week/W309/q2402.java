package Year2022.Week.W309;


import java.util.Arrays;
import java.util.PriorityQueue;

public class q2402 {
    public int mostBooked(int n, int[][] meetings) {
        // 双堆模拟 用两个小顶堆
        //idle维护在 starti 时刻空闲的会议室编号
        // using维护在starti 时刻使用中的会议室的结束时间和编号。
        int[] cnt = new int[n];
        PriorityQueue<Integer> idle = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            idle.offer(i);
        }
        // int[] 第一个 结束时间 第二个 会议室号码
        PriorityQueue<int[]> using = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        for(int[] meeting : meetings){
            int st = meeting[0], end = meeting[1];
            while(!using.isEmpty() && using.peek()[0] <= st){
                // 维护在st时刻空闲的会议室
                idle.offer(using.poll()[1]);
            }

            int id;
            if(idle.isEmpty()){
                // 没用可用会议室, 找到最近可用的会议室
                int[] p = using.poll();
                end += p[0] - st;
                id = p[1];
            }else{
                id = idle.poll();
            }
            cnt[id] ++;
            using.offer(new int[]{end, id});
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(cnt[i] > cnt[ans]){
                ans = i;
            }
        }

        return ans;
    }
}
