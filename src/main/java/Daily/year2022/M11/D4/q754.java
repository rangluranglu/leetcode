package Daily.year2022.M11.D4;

public class q754 {
    public int reachNumber(int target) {
        // 一直向前走到超过终点 相距偶数，把其中一步反向走就可以
        target = Math.abs(target);

        int s = 0, t = 0;

        while(s < target || (s - target) % 2 == 1){
            s += ++t;
        }

        return t;

    }
}
