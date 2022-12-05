package WeekCompetition.year2022.W322;

public class q2490 {
    public boolean isCircularSentence(String sentence) {
        // my
        String[] s = sentence.split(" ");
        int n = s.length;

        for (int i = 0; i < n - 1; i++) {
            if(s[i].charAt(s[i].length() - 1) != s[i + 1].charAt(0)){
                return false;
            }
        }

        if(s[n - 1].charAt(s[n - 1].length() - 1) != s[0].charAt(0)){
            return false;
        }

        return true;
    }
}
