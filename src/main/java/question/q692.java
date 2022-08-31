package question;

import java.util.*;

public class q692 {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            queue.offer(entry);
            if(queue.size() > k){
                queue.poll();
            }
        }

        List<String> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            ans.add(queue.poll().getKey());
        }
        Collections.reverse(ans);
        return ans;

    }
}
