package Year2022.Week.W324;

import java.util.*;

public class q2508 {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        // 记录度数为奇数的节点， 记 m 为 odd 的长度
        // 如果 m == 2: x = odd[0] , y = odd[1]
            // 如果x, y 之间没有边， 连接
            // 有边，枚举 i
        // 如果 m == 4: a, b, c, d

        Set[] g = new Set[n + 1];
        Arrays.setAll(g, e-> new HashSet<>());

        for(List<Integer> edge : edges){
            int x = edge.get(0);
            int y = edge.get(1);

            g[x].add(y);
            g[y].add(x);
        }

        List<Integer> odd = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(g[i].size() % 2 > 0){
                odd.add(i);
            }
        }

        // 奇数的点数量
        int m = odd.size();
        if(m == 0){
            return true;
        }

        if(m == 2){
            int x = odd.get(0), y = odd.get(1);
            if(!g[x].contains(y)){
                return true;
            }

            for (int i = 1; i <= n; i++) {
                if(i != x && i != y && !g[i].contains(x) && !g[i].contains(y)){
                    return true;
                }
            }

            return false;
        }

        if(m == 4){
            int a = odd.get(0), b = odd.get(1), c = odd.get(2), d = odd.get(3);

            return !g[a].contains(b) && !g[c].contains(d) ||
                    !g[a].contains(c) && !g[b].contains(d) ||
                    !g[a].contains(d) && !g[b].contains(c);
        }

        return false;
    }
}
