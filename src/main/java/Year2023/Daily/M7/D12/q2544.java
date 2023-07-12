package Year2023.Daily.M7.D12;

public class q2544 {
    public int alternateDigitSum(int n) {
        int sum = 0;
        int length = 0;

        while (n != 0){
            int t = n % 10;
            sum += (length & 1) == 0 ? t : -1 * t;
            length ++;

            n /= 10;
        }

        return ((length & 1) == 1) ? sum : -1 * sum;
    }
}
