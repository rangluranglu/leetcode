package question;

import java.util.Arrays;

public class q611 {
    public int triangleNumber(int[] nums) {
        // 有效三角形的个数，排序
        int n = nums.length;
        Arrays.sort(nums);
        // 保证 a + b > c
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int k = i + 1;
            for(int j = i + 1; j < n; j++){
                while(k + 1 < n && nums[k + 1] < nums[i] + nums[j]){
                    k ++;
                }
                ans += Math.max(k - j, 0);
            }
        }

        return ans;
    }
}
