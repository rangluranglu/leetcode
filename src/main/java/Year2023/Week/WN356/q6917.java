package Year2023.Week.WN356;

import java.util.Arrays;

public class q6917 {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        Arrays.sort(hours);

        int i = 0;
        for (int hour : hours){
            if(hour >= target){
                break;
            }
            i ++;
        }

        return hours.length - i;
    }
}
