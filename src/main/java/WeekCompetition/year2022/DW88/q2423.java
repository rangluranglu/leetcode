package WeekCompetition.year2022.DW88;

import java.util.*;

public class q2423 {
    public boolean equalFrequency(String word) {
        // 为true情况:
        // 1.只有一种次数: 只有一种字母 || n种字母，每种字母的出现次数都为1
        // 2.只有两种次数: 只有一种字母的出现次数为1 || 1种字母的出现次数为n + 1，其他字母出现次数为n && n + 1次数的只有一种字母

        // 每个字母出现次数
        Map<Character, Integer> countMap = new HashMap<>();
        // 每种次数，对应有几个字母
        TreeMap<Integer, Integer> charMap = new TreeMap<>();

        for(char c : word.toCharArray()){
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        for(Character k : countMap.keySet()){
            charMap.put(countMap.get(k), charMap.getOrDefault(countMap.get(k), 0) + 1);
        }


        if(charMap.size() > 2){
            return false;
        }

        // 只有一种次数
        if(charMap.size() == 1){
            // 只有一个字母 或 次数是 1
            return countMap.size() == 1 || charMap.containsKey(1);
        }

        // 两种次数
        return charMap.containsKey(1) && charMap.get(1) == 1 || charMap.lastKey() - charMap.firstKey() == 1 && charMap.lastEntry().getValue() == 1;
    }
}
