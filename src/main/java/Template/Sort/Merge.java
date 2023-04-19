package Template.Sort;

/**
 * 归并排序
 * 时间复杂度 O(NlogN)
 * 空间复杂度 O(N)
 */
public class Merge extends SortExample{

    // 自顶向下的归并排序
    // 分治思想
    // 优化：对小规模子数组使用插入排序

    public static void sort1(int[] nums) {
        int n = nums.length;
        int[] tmp = new int[n];
        mergeSort1(nums, 0, nums.length - 1, tmp);
    }

    private static void mergeSort1(int[] nums, int lo, int hi, int[] tmp) {
        if(hi <= lo) return;
        
        int mid = lo + (hi - lo) / 2;
        mergeSort1(nums, lo, mid, tmp);
        mergeSort1(nums, mid + 1, hi, tmp);
        if(nums[mid] < nums[mid + 1]){
            // 已经有序
            return;
        }
        mergeTwoArray(nums, lo, mid, hi, tmp);
    }

    private static void mergeTwoArray(int[] nums, int lo, int mid, int hi, int[] tmp) {
        System.arraycopy(nums, lo, tmp, lo, hi - lo + 1);

        // 合并两个有序数组
        int i = lo, j = mid + 1;

        for(int k = lo; k <= hi; k++){
            // 往nums填
            if(i > mid) nums[k] = tmp[j++];
            else if(j > hi) nums[k] = tmp[i ++];
            else if(tmp[i] <= tmp[j]) nums[k] = tmp[i++];
            else nums[k] = tmp[j ++];
        }
    }

    // 自底向上的并归排序
    public static void sort2(int[] nums) {
        int n = nums.length;
        int[] tmp = new int[n];

        for(int sz = 1; sz < n; sz +=sz){
            // sz 子数组大小 初始值为1，每次翻倍
            for(int lo = 0; lo < n - sz; lo += sz + sz){
                //
                mergeTwoArray(nums, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, n - 1), tmp);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 6, 7, 4, 1};
        sort2(nums);
        show(nums);
    }
}
