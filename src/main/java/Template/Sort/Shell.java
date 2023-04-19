package Template.Sort;

/**
 * 希尔排序
 * 希尔排序为了加快速度简单地改进了插入排序，
 * 交换不相邻的元素以对数组的局部进行排序，并最终用插入排序将局部有序的数组排序。
 */
public class Shell extends SortExample{
    public static void sort(int[] nums) {
        int n = nums.length;

        int h = 1;

        while(h < n / 3){
            h = 3 * h + 1;
        }

        while (h >= 1){
            // 将数组变为h有序
            for(int i = h; i < n; i++){
                // 将a[i] 插入到 a[i-h], a[i-2*h], a[i-3*h] ... 之中
                for(int j = i; j >= h&& nums[j] < nums[j - h]; j -= h){
                    swap(nums, j, j - h);
                }

                h = h/3;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 6, 7, 4, 1};
        sort(nums);
        show(nums);
    }
}
