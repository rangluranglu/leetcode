package WeekCompetition.year2022.atemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class question1 {
    public int pivotInteger(int n) {
        int sum = (1 + n) * n / 2;
        System.out.println(sum);
        for (int i = n / 2; i <= n; i++){
            if(i * i + i < sum){
                continue;
            }else if(i * i + 1 == sum){
                return i;
            }else {
                return -1;
            }
        }

        return -1;
    }


    public int pivotInteger2(int n) {
        if(n == 1){
            return -1;
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
}
