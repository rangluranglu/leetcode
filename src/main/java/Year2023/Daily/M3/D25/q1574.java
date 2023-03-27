package Year2023.Daily.M3.D25;

import java.util.ArrayDeque;
import java.util.Deque;

public class q1574 {
    public int findLengthOfShortestSubarray(int[] arr) {
        // 删除子数组， 剩下非递减
        // 单调栈 不可行！

        // 双指针 -->  删除连续子数组
        int n = arr.length, j = n - 1;

        while (j > 0 && arr[j - 1] <= arr[j]){
            j --;
        }

        if(j == 0){
            return 0;
        }

        int ans = j;
        for(int i = 0; i < n; i++){
            while(j < n && arr[j] < arr[i]){
                j ++;
            }

            ans = Math.min(ans, j - i - 1);
            if(i + 1 < n && arr[i] > arr[i + 1]){
                break;
            }
        }

        return ans;
    }
}
