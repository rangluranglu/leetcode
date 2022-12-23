package WeekCompetition.year2022.DW92;

public class q2481 {
    public int numberOfCuts(int n) {
        // 有效切割：过圆心， 在圆上
        if(n == 1){
            return 0;
        }
        return (n & 1) == 0 ? n / 2 : n;
    }
}
