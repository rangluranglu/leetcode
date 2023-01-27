package Year2023.Daily.M1.D26;

public class q1663 {
    public String getSmallestString(int n, int k) {
        // 长度为n， 数值等于k， 字典序最小
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int lower = Math.max(1, k - (n - i) * 26);
            k -= lower;
            ans.append((char) ('a' + lower - 1));
        }
        return ans.toString();
    }
}
