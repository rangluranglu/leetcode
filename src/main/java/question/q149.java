package question;

import java.util.HashMap;
import java.util.Map;

public class q149 {

    // 枚举斜率，注意小数精度问题，用分数存储，注意约分和正负
    // 当我们枚举到点 i 时，我们只需要考虑编号大于 i 的点到点 i 的斜率，因为如果直线同时经过编号小于点 i 的点 j，那么当我们枚举到 j 时就已经考虑过该直线了；
    //当我们找到一条直线经过了图中超过半数的点时，我们即可以确定该直线即为经过最多点的直线；
    // 当我们枚举到点 i（假设编号从 0 开始）时，我们至多只能找到 n−i 个点共线。假设此前找到的共线的点的数量的最大值为 k，如果有 k≥n−i，那么此时我们即可停止枚举，因为不可能再找到更大的
    //

    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n <= 2){
            return n;
        }

        int ret = 0;
        for (int i = 0; i < n; i++) {
            if(ret >= n - i || ret > n / 2){
                break;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for(int j = i + 1; j < n; j++){
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];

                if(x == 0){
                    y = 1;
                }else if(y == 0){
                    x = 1;
                }else{
                    if(y < 0){
                        x = -x;
                        y = -y;
                    }
                    int gcyXY = gcd(Math.abs(x), Math.abs(y));
                    x /= gcyXY;
                    y /= gcyXY;
                }
                int key = y + x * 20001;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            int maxn = 0;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                int num = entry.getValue();
                maxn = Math.max(maxn, num + 1);
            }

            ret = Math.max(ret, maxn);
        }

        return ret;
    }

    public int gcd(int a, int b){
        return b!= 0 ? gcd(b, a%b) : a;
    }
}
