package Year2023.Week.DW99;

public class q2579 {
    public long coloredCells(int n) {
        // 找规律
        // n = 1,   1
        // n = 2,   5
        // n = 3,   13   3 * 3 + 4
        // n = 4,   25   4 * 4 + 9   n*n + (n - 1) * (n - 1)

        return (long) n*n + (long) (n - 1) * (n - 1);
     }
}
