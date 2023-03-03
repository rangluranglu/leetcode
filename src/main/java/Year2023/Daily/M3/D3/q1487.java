package Year2023.Daily.M3.D3;

import java.util.HashMap;
import java.util.Map;

public class q1487 {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[] ans = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String name = names[i];

            if(!map.containsKey(name)){
                ans[i] = name;
                map.put(name, 1);
            }else {
                int k = map.get(name);
                while (map.containsKey(addSuffix(name, k))){
                    k++;
                }

                ans[i] = addSuffix(name, k);
                map.put(name, k + 1);
                map.put(addSuffix(name, k), 1);
            }
        }

        return ans;
    }

    public String addSuffix(String name, int i){
        return name + "(" +i + ")";
    }
}
