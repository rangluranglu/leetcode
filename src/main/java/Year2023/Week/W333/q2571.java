package Year2023.Week.W333;

public class q2571 {
    public int minOperations(int n) {
        // 加上或减去 2的n次幂
        // 连续的1
        // 如果n 的最右为0 ， 右移， 不增加操作次数
        // n 的两个连续的 1 以上， 做 +1 操作， step ++
        // 只有 一个1, 做 -1 操作， step ++


        int step = 0;

        while (n != 0){
            if((n & 3) == 1){
                n ++;
                step ++;
            }


            if((n & 1) == 1){
                step ++;
            }

            n >>= 1;
        }

        return step;
    }
}
