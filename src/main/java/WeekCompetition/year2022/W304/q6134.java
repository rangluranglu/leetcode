package WeekCompetition.year2022.W304;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class q6134 {
    public static void main(String[] args) {
        int[] nums = {1,2,-1};
        int ans = closestMeetingNode(nums, 0, 2);
        System.out.printf("" + ans);
    }

    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        // bfs
        if(node1 == node2){
            return node1;
        }
        int n = edges.length;
        boolean[] visited1 = new boolean[n];
        boolean[] visited2 = new boolean[n];

        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        queue1.offer(node1);
        queue2.offer(node2);

        visited1[node1] = true;
        visited2[node2] = true;

        int level1 = 0, level2 = 0;
        List<Integer> list = new ArrayList<Integer>();

        while(!queue1.isEmpty() || !queue2.isEmpty()){
            level1 ++;
            int len = queue1.size();
            while(len -- > 0){
                int n1 = queue1.poll();
                if(edges[n1] == -1 || visited1[edges[n1]]){
                    continue;
                }
                if(visited2[edges[n1]]){
                    list.add(edges[n1]);
                    break;
                }else{
                    queue1.offer(edges[n1]);
                    visited1[edges[n1]] = true;
                }
            }

            level2 ++;
            len = queue2.size();
            while(len-- > 0){
                int n2 = queue2.poll();
                if(edges[n2] == -1 || visited2[edges[n2]]){
                    continue;
                }

                if(visited1[edges[n2]]) {
                    list.add(edges[n2]);
                    break;
                }else {
                    queue2.offer(edges[n2]);
                    visited2[edges[n2]] = true;
                }
            }
            if(!list.isEmpty()){
                int ans = Integer.MAX_VALUE;
                for(int l : list){
                    if(l <= ans){
                        ans = l;
                    }
                }
                return ans;
            }
        }

        return -1;


    }
}
