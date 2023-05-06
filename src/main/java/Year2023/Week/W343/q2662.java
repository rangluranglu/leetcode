package Year2023.Week.W343;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class q2662 {
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        // 最短路径
        // dijkstra 最短路径算法

        long t = (long) target[0] << 32 | target[1];

        Map<Long, Integer> dis = new HashMap<>();
        dis.put(t, Integer.MAX_VALUE);
        dis.put((long) start[0] << 32 | start[1], 0);

        Set<Long> vis = new HashSet<>();


        for(;;){
            long v = -1;
            int dv = -1;

            // 找到目前能达到的距离最小的点
            for (Map.Entry<Long, Integer> e : dis.entrySet()) {
                if(!vis.contains(e.getKey()) && (dv < 0 || e.getValue() < dv)){
                    v = e.getKey();
                    dv = e.getValue();
                }
            }

            if(v == t){
                return dv;
            }

            // 添加访问
            vis.add(v);

            // 找到坐标
            int vx = (int) (v >> 32), vy = (int) (v & Integer.MAX_VALUE);

            // 更新距离
            dis.merge(t, dv + target[0] - vx + target[1] - vy, Math::min);

            // 小路
            for(int[] r : specialRoads){
                int d = dv + Math.abs(r[0] - vx) + Math.abs(r[1] - vy) + r[4];

                long w = (long) r[2] << 32 | r[3];

                if(d < dis.getOrDefault(w, Integer.MAX_VALUE)){
                    dis.put(w, d);
                }
            }



        }


    }
}
