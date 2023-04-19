package Template.Sort;

/**
 * 选择排序
 *
 * 时间复杂度 O(N^2)
 * 空间复杂度 O(1)
 */
public class Selection extends SortExample {

    // 大约需要 N^2 / 2 次比较 和 N 次交换
    public static void sort(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if(nums[j] < nums[min]){
                    min = j;
                }
            }

            swap(nums, i, min);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 6, 7, 4, 1};
        sort(nums);
        show(nums);
    }
}
