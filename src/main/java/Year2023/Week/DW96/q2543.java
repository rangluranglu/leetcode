package Year2023.Week.DW96;

public class q2543 {
    public boolean isReachable(int targetX, int targetY) {
        // (x, y) --> (1, 1) 做法
        // 1. 坐标相加
        // 2. 坐标除2

        // x, y 都是偶数， 不断循环直到 x=y 且均为奇数
        // 前 2 种移动方案下，(x,y) 能够到达 (ax+by,cx+dy)，根据贝祖定理，g = 1
        // 后 2 种移动方案下，g 可以扩大到 2^k

        int g = gcd(targetX, targetY);

        return (g & (g - 1)) == 0;

    }

    private int gcd(int a, int b){

        while (b != 0){
            int tmp = a;
            a = b;
            b = tmp % a;
        }
        return a;

    }
}
