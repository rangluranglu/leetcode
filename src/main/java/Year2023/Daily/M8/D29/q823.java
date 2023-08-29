package Year2023.Daily.M8.D29;

import java.util.Arrays;

public class q823 {
    public int numFactoredBinaryTrees(int[] arr) {
        // 使用任意次数， 非叶子节点 = 两个叶子节点的乘积
        // 动态规划 + 双指针

        Arrays.sort(arr);
        int n = arr.length;

        long[] dp = new long[n];
        long ans = 0, mod = (long) 1e9 + 7;


        for(int i = 0; i < n; i++){
            dp[i] = 1;

            for(int left = 0, right = i - 1; left <= right; left ++){
                while (right >= left && (long) arr[left] * arr[right] > arr[i]){
                    right --;
                }

                if(right >= left && (long) arr[left] * arr[right] == arr[i]){
                    if(right != left){
                        dp[i] = (dp[i] + dp[left] * dp[right] * 2) % mod;
                    }else{
                        dp[i] = (dp[i] + dp[left] * dp[right]) % mod;
                    }
                }
            }

            ans = (ans + dp[i]) % mod;
        }

        return (int) ans;
    }
}
