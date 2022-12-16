package Daily.year2022.M12.D14;

import sun.security.krb5.internal.crypto.Aes128;

import java.util.Arrays;

public class q1697 {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {

        // 并查集
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);

        Integer[] index = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            index[i] = i;
        }

        Arrays.sort(index, (a, b) -> queries[a][2] - queries[b][2]);


        int[] uf = new int[n];
        for (int i = 0; i < n; i++) {
            uf[i] = i;
        }

        boolean[] ans = new boolean[queries.length];

        int k = 0;

        for (int i : index) {
            // 遍历查询
            while (k < edgeList.length && edgeList[k][2] < queries[i][2]){
                merge(uf, edgeList[k][0], edgeList[k][1]);
                k ++;
            }

            ans[i] = find(uf, queries[i][0]) == find(uf, queries[i][1]);
        }

        return ans;
    }

    private void merge(int[] uf, int x, int y){
        x = find(uf, x);
        y = find(uf, y);
        uf[y] = x;
    }

    private int find(int[] uf, int x){
        if(uf[x] == x){
            return x;
        }

        return uf[x] = find(uf, uf[x]);
    }
}
