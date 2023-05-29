package question;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class q373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 最小的k对， 小根堆
        // 

        PriorityQueue<int[]> pq = new PriorityQueue<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        
        int m = nums1.length, n = nums2.length;

        // nums1 前k个
        for (int i = 0; i < Math.min(m, k); i++) {
            pq.offer(new int[]{i, 0});
        }

        while (k -- > 0 && !pq.isEmpty()){
            int[] idxPair = pq.poll();
            List<Integer> list = new ArrayList<>();

            list.add(nums1[idxPair[0]]);
            list.add(nums2[idxPair[1]]);

            ans.add(list);
            if(idxPair[1] + 1 < n){
                pq.offer(new int[]{idxPair[0], idxPair[1] + 1});
            }
        }

        return ans;
    }

}
