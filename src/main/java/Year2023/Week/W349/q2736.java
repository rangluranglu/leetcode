package Year2023.Week.W349;

import java.util.*;

public class q2736 {
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        // 排序 + 单调栈二分
        // 首先把nums1 和 xi 排序， 关注 nums2[j] 和 yi的关系

        int n = nums1.length;
        int q = queries.length;

        // 排序
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }

        // 升序排列 nums1
        Arrays.sort(idx, (i, j) -> nums1[i] - nums1[j]);


        // 降序排列 queries
        for (int i = 0; i < q; i++){
            queries[i] = new int[]{queries[i][0], queries[i][1], i};
        }
        Arrays.sort(queries, (i, j) -> j[0] - i[0]);

        // 计算

        int[] ans = new int[q];
        Arrays.fill(ans, -1);

        Deque<int[]> stack = new ArrayDeque<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        int id = n - 1;
        for(int[] query : queries){
            int x = query[0], y = query[1], qId = query[2];
            while (id >= 0 && nums1[idx[id]] >= x){
                // nums1 id符合条件， 查找 nums2
                int ax = nums1[idx[id]], ay = nums2[idx[id]];  // nums1 和 nums2
                while (!stack.isEmpty() && stack.peek()[1] <= ax + ay){
                    int[] pop = stack.pop();
                    treeMap.remove(pop[0]);
                }

                if(stack.isEmpty() || stack.peek()[0] < ay){
                    stack.push(new int[]{ay, ax + ay});
                    treeMap.put(ay, ax + ay);
                }

                id --;
            }

            // 单调栈二分 大于或等于给定键元素(ele)的最小键元素链接的键值对
            Map.Entry<Integer, Integer> entry = treeMap.ceilingEntry(y);
            if(entry != null){
                ans[qId] = entry.getValue();
            }
        }

        return ans;








    }
}
