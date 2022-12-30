package Year2022.Daily.M10.D16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // 深度优先
        return false;
    }


    public boolean possibleBipartition2(int n, int[][] dislikes) {
        // 并查集
        int[] fa = new int[n + 1];
        Arrays.fill(fa, -1);
        List<Integer>[] g = new List[n + 1];

        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<Integer>();
        }

        for(int[] p : dislikes){
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < g[i].size(); j++) {
                unit(g[i].get(0), g[i].get(j), fa);
                if(isconnect(i, g[i].get(j), fa)){
                    return false;
                }
            }
        }
        return true;
    }

    public void unit(int x, int y, int[] fa){
        x = findFa(x, fa);
        y = findFa(y, fa);

        if(x == y){
            return;
        }

        if(fa[x] < fa[y]){
            int tmp = x;
            x = y;
            y = tmp;
        }

        fa[x] += fa[y];
        fa[y] = x;
    }

    public boolean isconnect(int x, int y, int[] fa){
        x = findFa(x, fa);
        y = findFa(y, fa);
        return x == y;
    }

    public int findFa(int x, int[] fa){
        return fa[x] < 0 ? x : (fa[x] = findFa(fa[x], fa));
    }
}
