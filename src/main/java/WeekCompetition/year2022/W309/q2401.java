package WeekCompetition.year2022.W309;

import java.util.Arrays;

public class q2401 {
    public static void main(String[] args) {
        int[]  a = {84139415,693324769,614626365,497710833,615598711,264,65552,50331652,1,1048576,16384,544,270532608,151813349,221976871,678178917,845710321,751376227,331656525,739558112,267703680};
        System.out.println(longestNiceSubarray(a));
    }
    public static int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            boolean flag = false;
            int cnt = 1;
            for(int j = i - 1; j >= i - dp[i - 1]; j--){
                if((nums[i] & nums[j]) != 0){
                    flag = true;
                    break;
                }
                cnt += 1;
            }
            if(flag){
                dp[i] = cnt;
            }else {
                dp[i] = dp[i - 1] + 1;
                System.out.println();
            }
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(Arrays.toString(dp));
        return ans;

    }

    public int longestNiceSubarray1(int[] nums) {
        // 解法1：由于所有元素对按位与均为 0，在优雅子数组中的从低到高的第 i 个比特位上，至多有一个比特 1，其余均为比特 0。
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            int or = 0, j = i;
            while (j >= 0 && (or & nums[j]) == 0){
                or |= nums[j--];
            }
            ans = Math.max(ans, i - j);
        }
        return ans;
    }

    public int longestNiceSubarray2(int[] nums) {
        // 类似滑动窗口，用异或去除最左边元素
        int ans = 0;
        for (int left = 0, right = 0, or = 0; right < nums.length; right++) {
            while ((or & nums[right]) > 0)
                or ^= nums[left++];
            or |= nums[right];
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }


}
