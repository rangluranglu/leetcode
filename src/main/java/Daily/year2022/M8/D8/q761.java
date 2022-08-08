package Daily.year2022.M8.D8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class q761 {
    public String makeLargestSpecial(String s) {
        int n = s.length();
        if(n <= 2){
            return s;
        }

        int cnt = 0, left = 0;
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '1'){
                cnt++;
            }else {
                cnt --;
                if(cnt == 0){
                    ans.add("1" + makeLargestSpecial(s.substring(left + 1, i)) + "0");
                    left = i + 1;
                }
            }
        }

        Collections.sort(ans, (a, b)-> b.compareTo(a));
        StringBuilder sb = new StringBuilder();
        for(String sub : ans){
            sb.append(sub);
        }

        return sb.toString();
    }
}
