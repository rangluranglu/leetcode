package WeekCompetition.year2022.W307;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class q2385 {
    public static void main(String[] args) {
        int[] nums = {1, -2, 3, 4, -10, 12};
        System.out.println(kSum(nums, 16));
    }
    public static long kSum(int[] nums, int k) {
        PriorityQueue<Long> queue = new PriorityQueue<>();

        List<Long> list = new ArrayList<>();
        list.add(0L);
        queue.offer(0L);


        for(int i = 0; i < nums.length; i++){
            int size = list.size();
            for(int j = 0; j < size; j++){
                list.add(list.get(j) + nums[i]);
                queue.offer(list.get(list.size() - 1));
                if(queue.size() > k){
                    queue.poll();
                }
            }
        }
        System.out.println(Arrays.toString(queue.toArray()));

        return queue.peek();
    }
}
