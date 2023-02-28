package Year2023.Daily.M2.D28;

import java.util.*;

public class q2363 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] ints : items1) {
            map.put(ints[0], map.getOrDefault(ints[0], 0) + ints[1]);
        }

        for (int[] ints : items2) {
            map.put(ints[0], map.getOrDefault(ints[0], 0) + ints[1]);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey(), v = entry.getValue();
            res.add(new ArrayList<Integer>(){{add(key); add(v);}});
        }

        Collections.sort(res, (a, b) -> a.get(0) - b.get(0));

        return res;
    }
}
