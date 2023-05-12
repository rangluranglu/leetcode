package Year2023.Daily.M5.D12;

public class q1330 {
    public int maxValueAfterReverse(int[] nums) {
        // 最大值
        // 初始

        // sum = (nums[1] - nums[0]) + (nums[2] - nums[1]) + ... + (nums[n-1] - nums[n-2]);

        // 翻转 [i, j]
        // sum = pre + (nums[i-1] - nums[i-2]) + (nums[j]-nums[i-1]) + nums[   +

        // 翻转[i, j]  nums[i] - nums[i-1] --> nums[j] - nums[i-1];
        //            nums[j+1] - nums[j] --> nums[j + 1] - nums[i];

        // max(|nums[j] - nums[i-1]| + |nums[j + 1] - nums[i]| - |nums[i] - nums[i-1]| - |nums[j+1] - nums[j]|);
        int base = 0, d = 0, n = nums.length;
        int mx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int a = nums[i - 1], b = nums[i];
            int dab = Math.abs(a - b);
            base += dab;
            mx = Math.max(mx, Math.min(a, b));
            mn = Math.min(mn, Math.max(a, b));
            d = Math.max(d, Math.max(Math.abs(nums[0] - b) - dab, // i=0
                    Math.abs(nums[n - 1] - a) - dab)); // j=n-1
        }
        return base + Math.max(d, 2 * (mx - mn));
    }
}
