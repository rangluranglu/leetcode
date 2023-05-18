package Year2023.Week.W344;

public class q2672 {

    public int[] colorTheArray(int n, int[][] queries) {

        // 模拟
        int m = queries.length;
        int cnt = 0;
        int[] ans = new int[m], a = new int[n + 2];

        for(int qi = 0; qi < m; qi ++){
            int i = queries[qi][0] + 1, c = queries[qi][1]; // 下标从1开始

            // 去掉当前元素对cnt的影响
            if(a[i] > 0){
                cnt -= (a[i] == a[i-1] ? 1 : 0) + (a[1] == a[i +  1] ? 1 : 0);
            }

            a[i] = c;
            cnt += (a[i] == a[i - 1] ? 1 : 0) + (a[i] == a[i + 1] ? 1 : 0);
            ans[qi] = cnt;
        }

        return ans;
    }

}
