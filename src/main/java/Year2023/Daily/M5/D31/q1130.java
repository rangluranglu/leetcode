package Year2023.Daily.M5.D31;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class q1130 {
    public int mctFromLeafValues(int[] arr) {
        // 中序遍历， 叶子节点， 0或2个节点
        // arr.length 和 高度的关系

        // 动态规划
        // dp[i][j] 对应子树所有非叶子节点的最小总和，
        // dp[i][j] = min(dp[i][k] + dp[k +1][j] + mik * m(k+1)j)

        int n = arr.length;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        int[][] maxVal = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            maxVal[i][i] = arr[i];
            dp[i][i] = 0;   // 初始化

            for(int j = i +1; j < n; j++){
                maxVal[i][j] = Math.max(arr[j], maxVal[i][j - 1]);

                for(int k = i; k < j; k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + maxVal[i][k] * maxVal[k + 1][j]);
                }
            }
        }


        return dp[0][n - 1];
    }

    public int mctFromLeafValues2(int[] arr) {
        // 中序遍历， 叶子节点， 0或2个节点
        // arr.length 和 高度的关系

        // 单调栈，自下向上构建二叉树,栈元素从底到顶是严格递减的
        // 给定一个数组 arr，不断地合并相邻的数，合并代价为两个数的乘积，合并之后的数为两个数的最大值，直到数组只剩一个数，求最小合并代价和。

        int n = arr.length;

        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int x : arr){
            while (!stack.isEmpty() && stack.peek() <= x){
                int y = stack.pop();
                if(stack.isEmpty() || stack.peek() > x){
                    ans += y * x;
                }else {
                    ans += stack.peek() * y;
                }
            }

            stack.push(x);
        }

        while (stack.size() >= 2){
            int x = stack.pop();
            ans += stack.peek() * x;
        }

        return ans;

    }
}
