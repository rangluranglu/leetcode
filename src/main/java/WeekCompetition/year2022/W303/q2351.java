package WeekCompetition.year2022.W303;

public class q2351 {
    public char repeatedCharacter(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            if(++count[c - 'a'] == 2){
                return c;
            }

        }

        return 'a';
    }
}
