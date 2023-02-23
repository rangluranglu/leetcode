package Year2023.Daily.M2.D23;

import java.util.ArrayList;
import java.util.List;

public class q1238 {
    public List<Integer> circularPermutation(int n, int start) {
        // 1238.循环码排列

        List<Integer> ans = new ArrayList<>();
        ans.add(start);

        for (int i = 1; i <= n; i++) {
            int m = ans.size();
            for(int j = m - 1; j >= 0; j--){
                ans.add(((ans.get(j) ^ start) | (1 << (i - 1))) ^ start);
            }
        }

        return ans;
    }

    public List<Integer> circularPermutation2(int n, int start) {
        // 1238.循环码排列
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            ans.add((i >> 1) ^ i ^ start);
        }

        return ans;
    }
}
