package Year2022.Daily.M12.D21;

public class q1753 {
    public int maximumScore(int a, int b, int c) {
        // 最大分数
        // 贪心
        // 分情况讨论
        // a + b <= c; 答案为 a + b;
        // a + b > c;  (k1 + k2) + [(a - k1) + (b - k2) / 2] --> [(a +b + c) / 2]

        int sum = a + b +c;

        int maxVal = Math.max(Math.max(a, b), c);

        return Math.min(sum - maxVal, sum / 2);
    }
}
