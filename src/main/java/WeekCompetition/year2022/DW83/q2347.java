package WeekCompetition.year2022.DW83;

public class q2347 {
    public String bestHand(int[] ranks, char[] suits) {
        final String q1 = "Flush";
        final String q2 = "Three of a Kind";
        final String q3 = "Pair";
        final String q4 = "High Card";

        boolean flag = true;
        for(int i = 0; i < 4; i++){
            if(suits[i] != suits[i +1]){
                flag = false;
                break;
            }
        }

        if(flag){
            return q1;
        }

        int[] counts = new int[14];
        for(int i = 0; i < 5; i++){
            counts[ranks[i]]++;
            if(counts[ranks[i]] == 3){
                return q2;
            }
        }

        for(int i = 0; i < 14; i++){
            if(counts[i] == 2){
                return q3;
            }
        }

        return q4;
    }

}
