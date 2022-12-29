package question;

import java.util.*;

public class q1345 {
    public int minJumps(int[] arr) {
        // 到达数组最后一个下标的最小操作次数
        // bfs
        // 特例判断
        if(arr == null || arr.length == 0){
            return 0;
        }

        int n = arr.length;
        if(n == 1){
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();

        // 构造map
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], (a)->new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        boolean[] visited = new boolean[n];
        Deque<Integer> queue = new ArrayDeque<>();

        // 初始化
        int ans = 0;
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()){
            int size = queue.size();

            while (size-- > 0){
                int node = queue.poll();
                if(node == n - 1){
                    return ans;
                }

                // 下一步
                if(node - 1 >= 0 && !visited[node - 1]){
                    queue.offer(node - 1);
                    visited[node - 1] = true;
                }
                if(node + 1 < n && !visited[node + 1]){
                    queue.offer(node + 1);
                    visited[node + 1] = true;
                }

                for(int nxt : map.get(arr[node])){
                    if(!visited[nxt]){
                        queue.offer(nxt);
                        visited[nxt] = true;
                    }
                }

                map.get(arr[node]).clear();
            }
            ans++;

        }

        return -1;
    }
}
