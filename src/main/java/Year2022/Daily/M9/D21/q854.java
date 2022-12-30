package Year2022.Daily.M9.D21;

import java.util.*;

public class q854 {
    char[] target;
    int ans = Integer.MAX_VALUE;
    public int kSimilarity(String s1, String s2) {
        // 交换位置
        target = s2.toCharArray();
        // 回溯
        backtrace(s1.toCharArray(), 0, 0);
        return ans;
    }


    public void backtrace(char[] s1, int index, int count){
        if(index == s1.length){
            ans = Math.min(count, ans);
            return ;
        }

        if(count >= ans){
            return;
        }

        if(s1[index] != target[index]){
            // 回溯
            for (int i = index + 1; i < s1.length; i++) {
                if(s1[i] == target[index] && s1[i] != target[i]){
                    swap(s1, i, index);
                    backtrace(s1, index + 1, count + 1);
                    swap(s1, i, index);
                }
            }
        }else {
            backtrace(s1, index + 1, count);
        }
    }


    private void swap(char[] s, int i, int j){
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    // 启发式搜索
    int n;
    String t;
    public int kSimilarity2(String s1, String s2) {
        // 启发式搜索
        if(s1.equals(s2)){
            return 0;
        }

        t = s2;
        n = s1.length();
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) ->{
            // f = g + h
            int v1 = h(a), v2 = h(b), g1 = map.get(a), g2 = map.get(b);

            return (v1 + g1) - (v2 + g2);
        });
        map.put(s1, 0);
        pq.add(s1);

        while(!pq.isEmpty()){
            String poll = pq.poll();
            int step = map.get(poll);
            char[] cs = poll.toCharArray();
            int idx = 0;
            while(idx < n && cs[idx] == t.charAt(idx)){
                idx++;
            }

            for (int i = idx + 1; i < n; i++){
                if(cs[i] != t.charAt(idx) || cs[i] == t.charAt(i)){
                    continue;
                }
                swap(cs, idx, i);
                String nextStr = String.valueOf(cs);
                swap(cs, idx, i);

                if(map.containsKey(nextStr) && map.get(nextStr) <= step + 1){
                    continue;
                }

                if(nextStr.equals(t)){
                    return step + 1;
                }

                map.put(nextStr, step + 1);
                pq.add(nextStr);
            }
        }

        return -1;
    }

    private int h(String s){
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += s.charAt(i) != t.charAt(i) ? 1 : 0;

        }
        return (ans + 1) >> 1;
    }
}
