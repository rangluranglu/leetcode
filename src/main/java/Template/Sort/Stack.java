package Template.Sort;

/**
 * 堆排序
 * 时间复杂度 O(NlogN)
 * 空间复杂度 O(1)
 */
public class Stack extends SortExample{
    public static void sort(int[] nums) {
        int n = nums.length;

        heapify(nums);

        for(int i = n - 1; i >= 1; ){
            // 把堆顶元素移动到末尾
            swap(nums, 0, i);

            i--;

            shiftDown(nums, 0, i);
        }
    }

    // 构造堆
    public static void heapify(int[] nums){
        int len = nums.length;

        for(int i = (len - 1) / 2; i >= 0; i--){
            shiftDown(nums, i, len -1);
        }
    }

    private static void shiftDown(int[] nums, int k, int end){
        // 下沉元素
        while (2 * k + 1 <= end){
            // 有左孩子

            int j = 2 * k + 1;
            if(j + 1 <= end && nums[j + 1] > nums[j]){
                j++;
            }

            if(nums[j] > nums[k]){
                swap(nums, k, j);
            }else {
                break;
            }

            k = j;
        }
    }

}
