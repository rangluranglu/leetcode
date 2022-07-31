package Daily.year2022.M7.D29;

import java.util.Arrays;

public class q593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if(Arrays.equals(p1, p2)){
            return false;
        }

        long[] lens = new long[6];

        lens[0] = len(p1, p2);
        lens[1] = len(p1, p3);
        lens[2] = len(p1, p4);
        lens[3] = len(p2, p3);
        lens[4] = len(p2, p4);
        lens[5] = len(p3, p4);

        Arrays.sort(lens);
        return lens[0] == lens[3] && lens[4] == lens[5];
    }

    public long len(int[] x, int[] y){
        return (long) Math.pow(y[0] - x[0], 2) +  (long) Math.pow(y[1] - x[1], 2);
    }
}
