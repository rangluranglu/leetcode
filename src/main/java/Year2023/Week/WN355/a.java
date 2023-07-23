package Year2023.Week.WN355;

import java.util.ArrayList;
import java.util.List;

public class a {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < words.size(); i++) {
            String q = words.get(i);
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < q.length(); j++) {
                if(q.charAt(j) == separator){
                    if(sb.length() > 0){
                        ans.add(sb.toString());
                    }
                    sb.setLength(0);
                } else{
                    sb.append(q.charAt(j));
                }

                if(sb.length() > 0){
                    ans.add(sb.toString());
                }
            }
        }

        return ans;
    }
}
