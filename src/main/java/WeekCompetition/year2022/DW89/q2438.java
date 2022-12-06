package WeekCompetition.year2022.DW89;

import java.util.ArrayList;
import java.util.List;

public class q2438 {
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> list = new ArrayList<>();

        int MOD = (int) (1e9 + 7);

        while (n != 0){
            list.add(n & (-n)); // 获得最低位的1
            n &= (n - 1); // 消去最低位的 1
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long sum = 1;
            for(int j = queries[i][0]; j <= queries[i][1]; j++){
                sum = (sum * list.get(j)) % MOD;
            }

            ans[i] = (int) sum;
        }

        return ans;

    }
}
