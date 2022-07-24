package Daily.year2022.M7.D23;

import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;

public class Offer115 {
    public static void main(String[] args) {
        int[] nums = {1,4,2,3};
        int[][] seqs = {{1, 2}, {1, 3}, {2, 3}, {4, 2}, {1, 4}};

        System.out.println(sequenceReconstruction(nums, seqs));
    }
    public static boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        // 拓扑排序
        int n = nums.length;
        int[] indegrees = new int[n + 1];
        Set<Integer>[] graph = new Set[n + 1];

        for(int i = 1; i <= n; i++){
            graph[i] = new HashSet<Integer>();
        }

        for(int[] sequence : sequences){
            int size = sequence.length;
            for(int i = 1; i < size; i++){
                int prev = sequence[i - 1], next = sequence[i];
                if(graph[prev].add(next)){
                    // 入度加一
                    indegrees[next] ++;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        // 找到入度为0
        for(int i = 1; i <= n; i++){
            if(indegrees[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            if(queue.size() > 1){
                return false;
            }

            int index = queue.poll();
            for(int next :graph[index]){
                indegrees[next] --;
                if(indegrees[next] == 0){
                    queue.offer(next);
                }
            }
        }

        return true;
    }
}
