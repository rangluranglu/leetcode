package Year2023.Daily.M6.D8;

public class q1240 {

    int ans;
    public int tilingRectangle(int n, int m) {
        // 正方瓷砖 来铺地板 --> 最少
        // 可以分割为子问题 ? 不一定是最少的， 最少的有可能不规则？  --> 如何处理这种情况
        // 数学问题 ：结论
        // h(n, m) <= max(n, m)
        // h(n + m, m) = 1 + h(n, m)    if 1 <= m <= 4
        // h(n + m, m) = 1 + h(n, m)     if 3n >= m ^ 2

        ans = Math.max(n, m);
        boolean[][] rect = new boolean[n][m];
        dfs(0, 0, rect, 0);

        return ans;
    }


    public void dfs(int x, int y, boolean[][] rect, int cnt) {
        int n = rect.length, m = rect[0].length;
        if (cnt >= ans) {
            return;
        }
        if (x >= n) {
            ans = cnt;
            return;
        }
        /* 检测下一行 */
        if (y >= m) {
            dfs(x + 1, 0, rect, cnt);
            return;
        }
        /* 如当前已经被覆盖，则直接尝试下一个位置 */
        if (rect[x][y]) {
            dfs(x, y + 1, rect, cnt);
            return;
        }

        for (int k = Math.min(n - x, m - y); k >= 1 && isAvailable(rect, x, y, k); k--) {
            /* 将长度为 k 的正方形区域标记覆盖 */
            fillUp(rect, x, y, k, true);
            /* 跳过 k 个位置开始检测 */
            dfs(x, y + k, rect, cnt + 1);
            fillUp(rect, x, y, k, false);
        }
    }

    public boolean isAvailable(boolean[][] rect, int x, int y, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (rect[x + i][y + j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void fillUp(boolean[][] rect, int x, int y, int k, boolean val) {
        for (int i = 0; i < k; i++){
            for (int j = 0; j < k; j++) {
                rect[x + i][y + j] = val;
            }
        }
    }
}
