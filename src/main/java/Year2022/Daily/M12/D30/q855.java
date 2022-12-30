package Year2022.Daily.M12.D30;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class q855 {
}

class ExamRoom {
    // 选择 s = s1 + [(s2 - s1) / 2]

    // 要求 ： 实时的维护顺序关系，实时的获取最优区间， 删除后更新关系

    // 使用有序合集seats 保存已有学生的座位编号
    // 优先队列pq 保存座位区间
    // 如果 [s2 - s1 / 2] > [s4 - s3 / 2] 或者 [s2 - s1 / 2] == [s4 - s3 /2] and s1 < s2 区间[s1, s2] 比区间 更优

    // 座位
    TreeSet<Integer> seats;
    // 区间
    PriorityQueue<int[]> pq;
    int n;

    public ExamRoom(int n) {
        this.n = n;
        this.seats = new TreeSet<>();
        this.pq = new PriorityQueue<int[]>((a, b) ->{
            int d1 = a[1] - a[0], d2 = b[1] - b[0];

            return d1 / 2 > d2 / 2 || (d1 / 2 == d2 / 2 && a[0] < b[0]) ? -1 : 1;
        });
    }

    public int seat() {
        if(seats.isEmpty()){
            seats.add(0);
            return 0;
        }

        int left = seats.first(), right = n - 1 - seats.last();

        // 座位个数大于等于2
        while (seats.size() >= 2){
            // 取出最优先区间
            int[] p = pq.peek();

            // 区间没有中间节点， 有中间节点的化表示延迟删除
            if(seats.contains(p[0]) && seats.contains(p[1]) && seats.higher(p[0]) == p[1]){
                int d = p[1] - p[0];
                if(d / 2 < right || d / 2 <= left){
                    // 最左或最右的座位优先
                    break;
                }

                pq.poll();
                pq.offer(new int[]{p[0], p[0] + d / 2});
                pq.offer(new int[] {p[0] + d/2, p[1]});
                seats.add(p[0] + d/ 2);
                return p[0] + d / 2;
            }
            // leave 函数中延迟删除的区间在此时删除
            pq.poll();
        }

        if(right > left){
            pq.offer(new int[]{seats.last(), n - 1});
            seats.add(n - 1);
            return n - 1;
        } else {
            pq.offer(new int[]{0, seats.first()});
            seats.add(0);
            return 0;
        }
    }

    public void leave(int p) {
        if (p != seats.first() && p != seats.last()) {
            int prev = seats.lower(p), next = seats.higher(p);
            // pq 还没删除 [1, 4]  [4, 7] 没有删除， 直接添加 [1, 7]
            pq.offer(new int[]{prev, next});
        }
        seats.remove(p);

    }
}
