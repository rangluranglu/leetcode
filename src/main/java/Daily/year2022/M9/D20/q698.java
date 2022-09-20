package Daily.year2022.M9.D20;

import java.util.Arrays;

public class q698 {
    public static void main(String[] args) {
        System.out.println(1 << 16);
        System.out.println(Math.pow(2, 16));
    }

    int[] nums;
    boolean[] dp;
    int per, n;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 状态压缩和记忆化搜索
        int sum = Arrays.stream(nums).sum();
        if(sum % k != 0){
            return false;
        }
        per = sum / k;
        this.nums = nums;
        Arrays.sort(nums);
        n = nums.length;

        if(nums[n - 1] > per){
            return false;
        }
        // dp[s] 在 数字状态为S的情况下是否可行 2的n次方个状态。
        dp = new boolean[1 << n];
        Arrays.fill(dp, true);

        return dfs((1 << n) - 1, 0);
    }
    public boolean dfs(int s, int p){
        if(s == 0){
            return true;
        }

        if(!dp[s]){
            return dp[s];
        }

        dp[s] = false;

        for (int i = 0; i < n; i++) {
            if(nums[i] + p > per){
                break;
            }

            if(((s >> i) & 1) != 0){
                if (dfs(s ^ (1 << i), (p + nums[i]) % per)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canPartitionKSubsets2(int[] nums, int k) {
        // 动态规划
        int all = Arrays.stream(nums).sum();
        if (all % k != 0) {
            return false;
        }
        int per = all / k;
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[n - 1] > per) {
            return false;
        }
        boolean[] dp = new boolean[1 << n];
        int[] curSum = new int[1 << n];
        dp[0] = true;

        // 动态规划
        for (int i = 0; i < 1 << n; i++) {
            if (!dp[i]) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (curSum[i] + nums[j] > per) {
                    break;
                }
                if (((i >> j) & 1) == 0) {
                    int next = i | (1 << j);
                    if (!dp[next]) {
                        curSum[next] = (curSum[i] + nums[j]) % per;
                        dp[next] = true;
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }

    public boolean canPartitionKSubsets3(int[] nums, int k) {
        // 回溯

        // 数据预处理
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if(sum % k != 0){
            return false;
        }

        // 增加剪枝命中率
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while(left < right){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left ++;
            right --;
        }

        int target = sum / k;
        int[] bucket = new int[k];

        return backtrack(nums, 0, bucket, k, target);
    }

    private boolean backtrack(int[] nums, int index, int[] bucket, int k, int target){
        // 结束条件
        if(index == nums.length){
            // 判断是否符合条件
            // 有人提出，其实这个地方不需要判断，因为当 index == num.length 时，所有球已经按要求装入所有桶，所以肯定是一个满足要求的解
            // 即：每个桶内球的和一定为 target
/*            for(int i = 0; i < k; i++){
                if(bucket[i] != target){
                    return false;
                }
                return true;
            }*/
            return true;
        }

        // 开始选择
        for (int i = 0; i < k; i++) {
            // 剪枝
            if(i > 0 && bucket[i] == bucket[i - 1]){
                continue;
            }
            if(bucket[i] + nums[index] > target){
                continue;
            }
            // 选择第i号桶
            bucket[i] += nums[index];

            // 处理下一个
            if(backtrack(nums, index + 1, bucket, k, target)){
                return true;
            }

            bucket[i] -= nums[index];
        }

        return false;
    }
}
