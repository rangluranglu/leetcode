package WeekCompetition.year2022.DW85;

public class q6159 {
    int[] fa;
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        int n = nums.length;

        fa = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            fa[i] = i;
        }

        long[] sum = new long[n + 1];
        long[] ans = new long[n];

        for (int i = n - 1; i > 0; i--){
            int x = removeQueries[i];
            int to = find(x + 1);
            // 合并 x和 x + 1
            fa[x] = to;
            sum[to] += sum[x] + nums[x];
            ans[i - 1] = Math.max(ans[i], sum[to]);
        }

        return ans;

    }

    int find(int x){
        int f= x;
        while(fa[f] != f){
            f = find(fa[f]);
        }

        int tmp = x;
        while(fa[tmp] != f){
            int t = tmp;
            tmp = fa[tmp];
            fa[t] = f;
        }

        return f;
    }
}
