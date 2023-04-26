package Year2023.Week.W340;

import java.util.Arrays;

public class q2616 {
    public int minimizeMax(int[] nums, int p) {
        // 最小化数对的最大差值
        // p个下标对 每个下标对取差值  p个差值的最大值最小 ， 每个下标出现一次


        // 二分答案

        // low ：0   hi： max - min
        // 满足条件判断： val 是否是p个最大差值的最小值
        // 如何判断：只有(p - 1)个 是小于val的，并且val存在
        // n = 10^5 暴力 O(n ^ 2 * lg(max - min);
        // 优化：
        // 先排序， 有效相邻匹配，差值最小
        //  如果可以选 nums[0] 和 nums[1] 答案等于 [n - 2个数的最多数对个数]
        // 不选nums[0] 为 [n - 1个数的最多数对个数]


        Arrays.sort(nums);
        int n = nums.length, left = 0, right = nums[n - 1] - nums[0];

        while (left <= right){
            // 闭区间
            int mid = left + (right - left) / 2;

            // 检索
            int cnt = 0;

            for(int i = 0; i < n - 1; i++){
                if(nums[i + 1] - nums[i] <= mid){
                    cnt ++;
                    i ++;
                }
            }

            if(cnt >= p){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return left;

    }
}
