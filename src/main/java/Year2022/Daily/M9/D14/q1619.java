package Year2022.Daily.M9.D14;

import java.util.Arrays;

public class q1619 {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;

        int part = 0;
        for(int i = n/20; i < 19 * n / 20; i++){
            part += arr[i];
        }

        return part/(n * 0.9);
    }
}
