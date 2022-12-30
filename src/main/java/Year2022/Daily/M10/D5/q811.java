package Year2022.Daily.M10.D5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> counts = new HashMap<>();

        for(String domain : cpdomains){
            int space = domain.indexOf(' ');
            int count = Integer.parseInt(domain.substring(0, space));
            String dom = domain.substring(space + 1);

            counts.put(dom, counts.getOrDefault(dom, 0) + count);

            for(int i = 0; i < dom.length(); i++){
                if(dom.charAt(i) == '.'){
                    String subString = dom.substring(i + 1);
                    counts.put(subString, counts.getOrDefault(subString, 0) + count);
                }
            }
        }

        for(Map.Entry<String, Integer> entry : counts.entrySet()){
            String subDomain = entry.getKey();
            int count = entry.getValue();
            ans.add(count + " " + subDomain);
        }

        return ans;
    }
}
