package WeekCompetition.year2022.W317;

public class q2457 {
    public long makeIntegerBeautiful(long n, int target) {
        // 进位
        if(target >= 108){
            return 0;
        }

        /*
         * 12345 1
         * n/10*10+10                12350
         * n/100*100+100             12400
         * n/1000*1000+1000          13000
         * n/10000*10000+10000       20000
         * n/100000*100000+100000   100000
         * 1000000==n*10
         */

        long i = 10;
        long m = n;

        do{
            int sum = 0;
            for(long j = m; j != 0; j/=10){
                sum += j % 10;
            }

            if(sum <= target){
                return m -n;
            }

            m = m / i * i + i;
            i *= 10;

        }while (i != m * 10);

        return m - n;
    }
}
