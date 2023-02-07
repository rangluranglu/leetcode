package Year2023.Daily.M2.D7;

import java.util.*;

public class q1604 {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        int n = keyName.length;
        Map<String, List<Integer>> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(keyName[i], a -> new ArrayList<>());
            map.get(keyName[i]).add(getMinutes(keyTime[i]));
        }

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();

            int size = list.size();
            Collections.sort(list);
            for(int i = 2; i < size; i++){
                if(list.get(i) - list.get(i - 2) <= 60){
                    ans.add(entry.getKey());
                    break;
                }
            }
        }

        Collections.sort(ans);
        return ans;

    }

    public int getMinutes(String time){
        return ((time.charAt(0) - '0') * 10 + (time.charAt(1) - '0')) * 60 + (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
    }
}
