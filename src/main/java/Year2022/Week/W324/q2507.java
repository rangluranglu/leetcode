package Year2022.Week.W324;

public class q2507 {
    public int smallestValue(int n) {

        while (true) {
            // 循环计算
            int x = n;
            int s = 0;
            int i = 2;

            while (i * i <= x) {
                while (x % i == 0) {
                    s += i;
                    x /= i;
                }
                i += 1;
            }

            if (x > 1) {
                s += x;
            }

            if (s == n) {
                return n;
            }

            n = s;
        }
    }
}
