package Year2023.Week.WN355;

import java.util.*;

public class d {

    private List<int[]>[] g;
    private Map<Integer, Integer> cnts;

    private long ans;
    public long countPalindromePaths(List<Integer> parent, String s) {
        // 至多一个字母出现奇数次，其余字母出现偶数次
        // 用26为二进制来压缩，奇偶性

        int n = parent.size();
        this.g = new ArrayList[n];

        Arrays.setAll(g, a -> new ArrayList<>());

        for (int i = 1; i < n; i++) {
            g[parent.get(i)].add(new int[]{i, 1 << (s.charAt(i) - 'a')});
        }

        this.cnts = new HashMap<>();
        dfs(0, 0);
        return ans;
    }


    private void dfs(int x, int xor){
        ans += cnts.getOrDefault(xor, 0);

        for (int i = 0; i < 26; i++) {
            ans += cnts.getOrDefault(xor ^ (1 << i), 0);
        }

        cnts.merge(xor, 1, Integer::sum);

        for(int[] nei : g[x]){
            int y = nei[0];
            int m = nei[1];

            dfs(y, xor ^ m);
        }
    }
}
