package Template.Sort;

/**
 * 插入排序
 * 时间复杂度 O(N^2)
 * 空间复杂度 O(1)
 */
public class Insertion extends SortExample{
    public static void sort(int[] nums) {
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            // 找到最小值 插入到 i-1的位置
            for(int j = i; j > 0 && nums[j] - nums[j - 1] < 0; j --){
                swap(nums, j , j - 1);
            }

        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 6, 7, 4, 1};
        sort(nums);
        show(nums);
    }

}
