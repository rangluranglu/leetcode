package Year2023.Week.W330;

public class q2552 {
    public long countQuadruplets(int[] nums) {
        // 0 <= i < j < k < l < n 且
        // nums[i] < nums[k] < nums[j] < nums[l]

        // 枚举 j, k nums[k] < nums[j]
        // k 的右侧比 nums[j] 大的 元素个数 great[k][nums[j]]
        // j 的左侧比 nums[k] 小的 元素个数 less[j][nums[k]]

        // less[j][nums[k]]  *  great[k][nums[j]]
        int n = nums.length;

        int[][] great = new int[n][n + 1];
        // 枚举k
        for(int k = n - 2; k >= 2; k--){
            great[k] = great[k + 1].clone();

            for(int x = nums[k + 1] - 1; x > 0; x--){
                great[k][x] ++; //  x < nums[k+1]，对于 x，大于它的数的个数 +1
            }
        }

        long ans = 0;
        // 枚举j
        int[] less = new int[n + 1];
        for(int j = 1; j < n - 2; j++){
            // 滚动
            for(int x = nums[j - 1] + 1; x <= n; x++){
                less[x] ++;
            }

            for(int k = j + 1; k <n - 1; k++){
                if(nums[j] > nums[k]){
                    ans += (long) less[nums[k]] * great[k][nums[j]];
                }
            }
        }

        return ans;

    }
}
