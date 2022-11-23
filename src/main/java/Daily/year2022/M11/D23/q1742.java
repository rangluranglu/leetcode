package Daily.year2022.M11.D23;

import java.util.Arrays;

public class q1742 {
    public int countBalls(int lowLimit, int highLimit) {
        int[] count = new int[46];
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = 0, tmp = i;
            while (tmp != 0){
                sum += tmp % 10;
                tmp /= 10;
            }

            count[sum] ++;
        }

        return Arrays.stream(count).max().getAsInt();
    }
}
