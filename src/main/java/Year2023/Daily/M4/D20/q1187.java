package Year2023.Daily.M4.D20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q1187 {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        // 从arr1 和 arr2 中选一个索引 arr1[i] = arr2[j]，最小操作数
        // 问题要点： 找到arr1中需要替换的数
        // 动态规划：最长递增子序列
        // 最多交换次数 min(m, n)

        // dp[i][j] 表示arr1 中 前i个进行了j交换后形成的严格递增的末尾元素的最小值
        // 如果arr[i] 保留 arr1[i] > dp[i - 1][j]

        // 如果arr[j] 不保留 需要arr2 中寻找替换值满足要求

        // dp[i][j] = min(dp[i][j], arr1[i])  arr1[i] > dp[i-1][j]
        // dp[i][j] = min(dp[i][j], arr2[k]) arr2[k] > dp[i - 1][j - 1]

        // 预处理arr2
        Arrays.sort(arr2);
        List<Integer> list = new ArrayList<>();
        for(int num : arr2){
            if(list.isEmpty() || num != list.get(list.size() - 1)){
                list.add(num);
            }
        }
        System.out.println(list);

        int m = arr1.length;
        int n = list.size();

        int[][] dp = new int[m + 1][Math.min(m, n) + 1];

        // 初始化
        for(int i = 0; i <= m; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = -1;
        for(int i = 1; i <= m; i++){
            for(int j = 0; j <= Math.min(i, n); j++){
                // 动态规划
                if(arr1[i - 1] > dp[i - 1][j]){
                    dp[i][j] = arr1[i -1];
                }

                if(j > 0 && dp[i - 1][j - 1] != Integer.MAX_VALUE){
                    // 查找大于等于dp[i - 1][j - 1] 的最小元素
                    int idx = binarySearch(list, j - 1, dp[i - 1][j - 1]);
                    if(idx != list.size()){
                        dp[i][j] = Math.min(dp[i][j], list.get(idx));
                    }
                }

                if(i == m && dp[i][j] != Integer.MAX_VALUE){
                    return j;
                }
            }
        }
        return -1;
    }

    public int binarySearch(List<Integer> list, int low, int target){
        int high = list.size();

        while (low < high){
            int mid = low + (high - low) / 2;

            if(list.get(mid) > target){
                high = mid;
            }else{
                low = mid + 1;
            }
        }

        return low;
    }
}
