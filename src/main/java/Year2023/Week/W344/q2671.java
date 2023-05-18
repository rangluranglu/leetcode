package Year2023.Week.W344;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class q2671 {
}

class FrequencyTracker {

    // 两个map， 分别记录
    Map<Integer, Integer> count;
    Map<Integer, Set<Integer>> frequency;

    public FrequencyTracker() {
        count = new HashMap<>();
        frequency = new HashMap<>();
    }

    public void add(int number) {
        count.put(number, count.getOrDefault(number, 0) + 1);

        int fre = count.get(number);
        if(fre > 1){
            frequency.get(fre - 1).remove(number);
        }

        frequency.computeIfAbsent(fre, a-> new HashSet<>());
        frequency.get(fre).add(number);
    }

    public void deleteOne(int number) {
        if(!count.containsKey(number)){
            return;
        }

        count.put(number, count.get(number) - 1);

        int fre = count.get(number);
        frequency.get(fre + 1).remove(number);
        if(fre == 0){
            count.remove(number);
        }else {
            frequency.get(fre).add(number);
        }
    }

    public boolean hasFrequency(int f) {
        return frequency.getOrDefault(f, new HashSet<>()).size() > 0;
    }
}
