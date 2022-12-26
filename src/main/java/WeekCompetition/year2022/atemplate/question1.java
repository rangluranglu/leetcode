package WeekCompetition.year2022.atemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class question1 {
    public int closetTarget(String[] words, String target, int startIndex) {
        int n = words.length;

        int index = startIndex;

        for (int i = 0; i <= n / 2; i++) {
            if(words[(index + i) % n].equals(target) || words[(index - i + n) %  n].equals(target)){
                return i;
            }
        }

        return -1;
    }
}
