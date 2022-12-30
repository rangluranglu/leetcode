package Year2022.Week.W324;

public class q2509 {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        // queries 互不影响
        // x , y -->  depth(x) + depth(y)

        // 问题 ：计算节点的高度
        // 第i层的个数 : 2^i ,
        // 前i层的个数 : 2^0 + ...... + 2^i ->  2^ (n + 1) - 1

        int k = queries.length;
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            int res = 1;

            while(x != y){
                // 找父节点
                if(x > y){
                    x /= 2;
                }else {
                    y /= 2;
                }
                res++;
            }

            ans[i] = res;
        }

        return ans;
    }
}
