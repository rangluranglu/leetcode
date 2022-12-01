package WeekCompetition.year2022.DW88;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class q2426 {
    long ans = 0;
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        // i < j;
        // (nums1[i] - nums2[i]) - (nums1[j] - nums2[j]) <= diff;
        // 总结 ： diffs[i] - diffs[j] <= diff 的 子数组数目 diffs[i] <= diff[j] + diff;

        // 逆序对模型

        int n = nums1.length;
        int[] diffs = new int[n];

        for (int i = 0; i < n; i++) {
            diffs[i] = nums1[i] - nums2[i];
        }

        // O(n*2) 会超时
        // 减少时间复杂度
        // 单调栈
        // 归并
        int[] tmp = new int[n];
        mergeSort(diffs, 0, n - 1, tmp, diff);
        return ans;
    }

    private void mergeSort(int[] diffs, int left, int right, int[] tmp, int diff) {

        if(left >= right){
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(diffs, left, mid, tmp, diff);
        mergeSort(diffs, mid + 1, right, tmp, diff);
        // 统计
        for(int i = left, j = mid + 1; j <= right; j++){
            while (i <= mid && (diffs[i] <= diffs[j] + diff)){
                i ++;
            }

            ans += (i - left);
        }

        mergeSortedArray(diffs, left, mid, right, tmp, diff);
    }

    private void mergeSortedArray(int[] diffs, int left, int mid, int right, int[] tmp, int diff) {

        System.arraycopy(diffs, left, tmp, left, right - left + 1);

        int i = left, j = mid + 1;

        for(int k = left; k <= right; k++){
            if(i == mid + 1){
                diffs[k] = tmp[j ++];
            }else if(j == right +1){
                diffs[k] = tmp[i];
                i++;
            }else if(tmp[i] <= tmp[j]){
                diffs[k] = tmp[i];
                i++;
            }else {
                diffs[k] = tmp[j ++];
            }

        }
    }
}
