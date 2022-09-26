package WeekCompetition.year2022.DW85;

public class q2380 {
    public int secondsToRemoveOccurrences(String s) {
        // dp
        int n = s.length();

        int pre = 0;
        int f = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '0'){
                pre ++;
            }else if(pre > 0){
                f = Math.max(f + 1, pre);
            }
        }

        return f;
    }
}
