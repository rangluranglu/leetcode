package Year2023.Week.W348;

import java.util.Arrays;

public class q2719 {
    private static final int MOD = (int) 1e9 + 7;
    private int minSum, maxSum;


    public int count(String num1, String num2, int min_sum, int max_sum) {
        // num1 <= x <= num2
        // min_sum <= digit_sum(x) <= max_sum;

        // 计算 <= num2 合法字数个数a， 计算 <= num1 - 1 合法字数个数b
        // 结果 a - b

        // 数位dp

        this.minSum = min_sum;
        this.maxSum = max_sum;

        int ans = count(num2) - count(num1) + MOD;
        int sum = 0;

        for (char c : num1.toCharArray()){
            sum += c - '0';
        }
        if(minSum <= sum && sum <= maxSum){
            ans ++;
        }
        return ans % MOD;

    }

    private int count(String str){
        char[] s = str.toCharArray();
        int n = s.length;

        // 记忆5
        int[][] memo = new int[n][Math.min(9 * n, maxSum) + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(memo[i], -1);
        }

        return f(s, memo, 0, 0, true);
    }


    // islimit 的作用
    private int f(char[] s, int[][] memo, int i, int sum, boolean isLimit){
        if(sum > maxSum) return 0;

        if(i == s.length) return sum >= minSum ? 1 : 0;

        if(!isLimit && memo[i][sum] != -1) return memo[i][sum];

        int res = 0;
        int up = isLimit ? s[i] - '0' : 9;
        for(int d = 0; d <= up; d++){
            res = (res + f(s, memo, i + 1, sum + d, isLimit && d== up)) % MOD;
        }

        if(!isLimit) memo[i][sum] = res;

        return res;
    }
}
