package WeekCompetition.year2022.atemplate;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class question2 {
    public int appendCharacters(String s, String t) {
        // 双指针
        int i = 0, j = 0;
        int m = s.length(), n = t.length();

        while (i < m && j < n){
            if(s.charAt(i) ==t.charAt(j)){
                i ++;
                j ++;
            }else {
                i ++;
            }
        }

        if(j == n){
            return 0;
        }else {
            return n - j;
        }
    }
}
