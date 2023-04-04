package Year2023.Week.W337;

import java.util.Arrays;

public class q2597 {
    private int[] nums, cnt;
    private int k, ans = -1;
    public int beautifulSubsets(int[] nums, int k) {

        // 子集型回溯
        this.nums = nums;
        this.k = k;
        cnt = new int[k * 2 + 1001];
        dfs(0);

        return ans;
    }

    private void dfs(int i){
        if(i == nums.length){
            ans ++;
            return;
        }

        // 不选
        dfs(i + 1);

        int x = nums[i] + k;
        // 避免下标负数

        if(cnt[x - k] == 0 && cnt[x + k] == 0){
            cnt[x] ++;
            dfs(i + 1);
            cnt[x] --;
        }
    }

    public int beautifulSubsets2(int[] nums, int k) {

        // nums 的子集中， 任意两个整数的绝对差均不等于k
        // 非空 且美丽子集的数目
        // 动态规划
        // 同余： (x - y) mod k == 0   --> x = y (mod k)
        int n = nums.length;
        Arrays.sort(nums);

        return 0;

    }
}
