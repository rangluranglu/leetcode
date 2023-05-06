package Year2023.Week.W342;

public class q2652 {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        // 每个长度为k的美丽值
        // 美丽值 --> 如果子数组中第 x 小整数 是 负数 ，那么美丽值为第 x 小的数，否则美丽值为 0 。

        // 统计负数
        // 滑动窗口 + 暴力计算
        int basic = 50;
        int[] cnt = new int[2 * basic + 1];

        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int negCount = 0;

        // 滑动窗口[left, right]
        int left = 0;
        for(int right = 0; right < n; right ++){
            cnt[nums[right] + 50] ++;
            if(right - left + 1 > k){
                cnt[nums[left] + 50] --;
                left ++;
            }

            if(right - left + 1 == k){
                // 长度为k, 进行统计
                int tmp = 0;
                for(int j = 0; j <= 2 * basic; j++){
                    // 第x小
                    tmp += cnt[j];
                    if(tmp >= x){
                        if(j < 50){
                            ans[left] = j - 50;
                        }else {
                            ans[left] = 0;
                        }
                        break;
                    }
                }
            }
        }

        return ans;
    }
}
