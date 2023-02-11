package Year2023.Daily.M2.D11;

import java.util.Arrays;

public class q2335 {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int ans = 0;

        if(amount[0] + amount[1] < amount[2]){

            return amount[2];
        }

        return (amount[0] + amount[1] + amount[2] + 1) / 2;
    }
}
