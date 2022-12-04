package WeekCompetition.year2022.atemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class question1 {
    public boolean isCircularSentence(String sentence) {
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
