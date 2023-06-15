package Year2023.Daily.M6.D15;

import java.util.ArrayList;
import java.util.List;

public class q1177 {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        // 重新排列子串， s[left],...,s[right]，选择最多k项 替换成任意小写文字

        int n = s.length(), m = queries.length;

        // 每次独立检测， 前缀数组
        char[] chars = s.toCharArray();

        int[] count = new int[n + 1];
        for (int i = 0; i < n; i++) {
            // 为什么异或， 统计出现次数的奇偶性
            count[i + 1] = count[i] ^ (1 << chars[i] - 'a');
        }

        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int l = queries[i][0], r = queries[i][1], k = queries[i][2];
            // x 是子串的奇偶性
            int bits = 0, x = count[r + 1] ^ count[l];

            while (x > 0){
                x &= x - 1;
                bits ++;
            }
            // 替换k个最多可以构成 k*2 + 1长度的回文串
            ans.add(bits <= k * 2 + 1);
        }

        return ans;
    }
}
