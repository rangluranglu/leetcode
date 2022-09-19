package WeekCompetition.year2022.DW87;

import java.util.Arrays;

public class q6185 {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int j = 0, k = trainers.length;
        for(int i = 0; i < players.length; i++){
           while(j < k && players[i] > trainers[j]){
               j++;
           }

           if(j == k){
               return i;
           }

           j += 1;
        }
        return players.length;
    }
}
