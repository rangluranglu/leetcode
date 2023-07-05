package Year2023.Week.DW104;

import java.util.Arrays;

public class q2679 {
    public int matrixSum(int[][] nums) {
        // 分析时间复制度  O(mnlog n + mn) = O(mnlog n)
        // 空间复杂   O(m logn)

        int m = nums.length, n = nums[0].length;

        for (int i = 0; i < m; i++) {
            Arrays.sort(nums[i]);
        }
        int ans = 0;
        for(int j = n - 1; j >= 0; j--){
            int mx = 0;
            for(int i = 0; i < m; i++){
                mx = Math.max(mx, nums[i][j]);
            }

            ans += mx;
        }
        return ans;
    }
}
