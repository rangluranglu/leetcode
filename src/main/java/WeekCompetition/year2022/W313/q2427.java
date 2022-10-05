package WeekCompetition.year2022.W313;

public class q2427 {
    public int commonFactors(int a, int b) {
        if(b < a){
            return commonFactors(b, a);
        }

        int ans = 0;
        for (int i = 1; i <= a ; i++) {
            if(a % i == 0 && b % i ==0 ){
                ans += 1;
            }
        }

        return ans;
    }
}
