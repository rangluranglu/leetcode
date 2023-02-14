package Year2023.Week.DW95;

import java.util.ArrayDeque;
import java.util.Queue;

public class q2526 {
}


class DataStream {
    // 最后k个是否等于value
    // queue 模拟


    int k, value, cnt;
    public DataStream(int value, int k) {
        this.k = k;
        this.value = value;
        this.cnt = 0;
    }

    public boolean consec(int num) {
        // 加入数据
        cnt = (num == value ? cnt + 1 : 0);
        return cnt >= k;
    }
}