package Year2022.Daily.M10.D29;

import java.util.List;

public class q1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int i = ruleKey.equals("type") ? 0 : (ruleKey.equals("color") ? 1 : 2);

        int ans = 0;

        for(List<String> item : items){
            if(item.get(i).equals(ruleValue)){
                ans ++;
            }
        }

        return ans;
    }
}
