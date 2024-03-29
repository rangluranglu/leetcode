package Year2023.Daily.M5.D28;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class q1439 {
    public int kthSmallest(int[][] mat, int k) {
        // 前置问题 373.查找和最小的k对数字
        int m = mat.length;
        int[] prev = mat[0];

        for (int i = 1; i <m; i++){
            prev = merge(prev, mat[i], k);
        }

        return prev[k - 1];
    }


    public int[] merge(int[] f, int[] g, int k){
        if(g.length > f.length){
            return merge(g, f, k);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < g.length; i++) {
            pq.offer(new int[]{0, i, f[0] + g[i]});
        }


        List<Integer> list = new ArrayList<>();
        while(k > 0 && !pq.isEmpty()){
            int[] entry = pq.poll();
            list.add(entry[2]);
            if(entry[0] + 1 < f.length){
                pq.offer(new int[]{entry[0] + 1, entry[1], f[entry[0] + 1] + g[entry[1]]});
            }

            k --;
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;

    }
}
