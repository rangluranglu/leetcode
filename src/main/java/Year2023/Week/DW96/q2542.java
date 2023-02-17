package Year2023.Week.DW96;


import java.util.Arrays;
import java.util.PriorityQueue;

public class q2542 {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        // 子序列 分数最大 -->
        // 排序 --> 以nums2为准， 逆序

        int n = nums1.length;
        Integer[] index = new Integer[n];

        Arrays.sort(index, (a, b) -> nums2[b] == nums2[a] ? nums1[b] - nums1[a] : nums2[b] - nums2[a] );
        System.out.println(Arrays.toString(index));
        // 小根堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long sum1 = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (pq.size() < k - 1) {
                pq.offer(nums1[index[i]]);
                sum1 += nums1[index[i]];

            } else {
                pq.offer(nums1[index[i]]);
                sum1 += nums1[index[i]];

                ans = Math.max((long) sum1 * nums2[index[i]], ans);

                sum1 -= pq.poll();
            }

        }
        return ans;
    }

}
