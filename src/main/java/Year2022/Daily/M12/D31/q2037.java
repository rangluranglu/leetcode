package Year2022.Daily.M12.D31;

import java.util.Arrays;

public class q2037 {
    public int minMovesToSeat(int[] seats, int[] students) {
        // 贪心
        Arrays.sort(seats);
        Arrays.sort(students);

        int ans = 0;

        for (int i = 0; i < seats.length; i++) {
            ans += Math.abs(seats[i] - students[i]);
        }

        return ans;
    }
}
