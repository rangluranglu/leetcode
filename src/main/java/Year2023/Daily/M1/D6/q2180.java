package Year2023.Daily.M1.D6;

public class q2180 {
    public int countEven(int num) {
        // 0 <= x < 10 , 个数为 [x / 2] + 1
        // num = 10 * y + x 其中 0 <= x <= 10 且  y >= 0;
        // 区间[0 , num] 分解为
        // --> [10 * y + 0, 10 * y + x]
        // 如果y的数字之和是偶数， 个数为 [x / 2] + 1
        // 如果y的数字之和是奇数， 个数为 [x / 2]
        // --> [0, 10 * y + 0)
        // 10 * t + g ，0 <= t < y 且 0 <= g < 10;
          // 规定 t ， t的


        int y = num / 10, x = num % 10;
        int res = y * 5, ySum = 0;

        while (y != 0){
            ySum += y % 10;
            y /= 10;
        }


        if(ySum % 2 == 0){
            res += x / 2 + 1;
        }else {
            res += (x + 1) / 2;
        }

        return res - 1;
    }
}
