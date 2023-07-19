package Year2023.Daily.M7.D19;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class q874 {

    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int robotSim(int[] commands, int[][] obstacles) {
        // 起始位置为(0, 0)，面向北方

        // 模拟
        Set<Integer> set = new HashSet<>();

        for(int[] obs : obstacles){
            set.add(obs[0] * 60001 + obs[1]);
        }
        int ans = 0;
        int d = 0;
        int sx = 0, sy = 0;
        for(int c : commands){
            if(c < 0){
                d += c == -1 ? 1 : -1;
                d = (d + 4) % 4;
            }else {
                for (int i = 0; i < c; i++) {
                    if(set.contains((sx + directions[d][0]) * 60001 + sy + directions[d][1])){
                        break;
                    }

                    sx += directions[d][0];
                    sy += directions[d][1];
                    ans = Math.max(ans, sx * sx + sy * sy);
                }
            }
        }

        return ans;

    }
}
