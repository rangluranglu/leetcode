package Year2022.Week.W315;

public class q2444 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        // 所有元素都在范围内，同时包含 minK 和 maxK 的子数组的个数

        long ans = 0L;
        int n = nums.length;
        int minI = -1, maxI = -1, i0 = -1;

        for (int i = 0; i < n; i++) {
            // 固定右端点
            int x = nums[i];

            if(x == minK){
                minI = i;
            }
            if(x == maxK){
                maxI = i;
            }

            if(x < minK || x > maxK){
                i0 = i;
            }

            ans += Math.max(Math.min(minI, maxI) - i0, 0);
        }

        return ans;
    }
}
