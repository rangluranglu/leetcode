package WeekCompetition.year2022.W321;

public class q2485 {
    public int pivotInteger(int n) {
        if(n == 1){
            return 1;
        }
        int sum = (1 + n) * n / 2;
        for (int i = 1; i <= n; i++) {
            if(countSum(i) == sum - countSum(i-1)){
                return i;
            }
        }
        return -1;
    }
    public int countSum(int n){
        return (1 + n) * n/ 2;
    }

    public int pivotInteger2(int n) {
        // 解方程得到 x = sqrt(n (n + 1) / 2)
        int m = n * (n + 1) / 2;
        int x = (int)Math.sqrt(m);
        if(x * x == m){
            return x;
        }else {
            return -1;
        }
    }

}
