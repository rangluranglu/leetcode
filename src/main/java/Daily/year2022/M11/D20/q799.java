package Daily.year2022.M11.D20;

public class q799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] row = {poured};

        for (int i = 0; i <= query_row; i++) {
            double[] newRow = new double[i + 1];

            for (int j = 1; j < i; j++) {
                double volume = row[j];
                if(volume > 1){
                    newRow[j] += (volume - 1) / 2;
                    newRow[j + 1] += (volume - 1) / 2;
                }
            }
            row = newRow;
        }
        return Math.min(1, row[query_glass]);
    }
}
