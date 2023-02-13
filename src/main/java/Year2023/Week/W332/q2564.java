package Year2023.Week.W332;

import com.sun.xml.internal.ws.api.ha.HaInfo;

import java.util.HashMap;
import java.util.Map;

public class q2564 {
    private final static int[] NOT_FOUNT=new int[]{-1, -1};
    public int[][] substringXorQueries(String s, int[][] queries) {
        int n = queries.length;
        int[][] ans = new int[n][2];
        for (int i = 0; i < n; i++) {
            int[] query = queries[i];

            int target = query[0] ^ query[1];
            String a = Integer.toBinaryString(target);
            System.out.println(a);
            int index = s.indexOf(a);
            if(index == -1){
                ans[i][0] = -1;
                ans[i][1] = -1;
            }else {
                ans[i][0] = index;
                ans[i][1] = index + a.length() - 1;
            }
        }

        return ans;
    }

    public int[][] substringXorQueries2(String s, int[][] queries) {
        // 预处理 10^9 < 2^30
        int n = s.length();
        Map<Integer, int[]> map = new HashMap<>();
        for (int l = 0; l < n; l++) {
            for(int r = l, x = 0; r < Math.min(l + 30, n); r++){
                x = (x << 1 | (s.charAt(r) & 1));
                if(!map.containsKey(x) || r - l < map.get(x)[1] - map.get(x)[0]){
                    map.put(x, new int[]{l, r});
                }
            }
        }
        int[][] ans = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            ans[i] = map.getOrDefault(queries[i][0] ^ queries[i][1], NOT_FOUNT);
        }

        return ans;
    }
}
