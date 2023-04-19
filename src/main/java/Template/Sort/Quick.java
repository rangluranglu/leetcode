package Template.Sort;


import java.util.Random;

/**
 * 快速排序
 * 时间复杂度 O(NlogN)
 * 空间复杂度 O(logN)
 */
public class Quick extends SortExample{

    private static final Random RANDOM = new Random();

    public static void sort(int[] nums) {
        int n = nums.length;
        quickSort(nums, 0, n - 1);
    }

    private static void quickSort(int[] nums, int lo, int hi){
        // 快速排序

        if(hi <= lo){
            return;
        }
        // 分割
        int pIndex = partition(nums, lo, hi);
        quickSort(nums, lo, pIndex - 1);
        quickSort(nums, pIndex + 1, hi);
    }


    // 基本快速排序
    private static int partition(int[] nums, int lo, int hi){

        int randomIndex = RANDOM.nextInt(hi - lo + 1) + lo;
        // 交换到左边
        swap(nums, randomIndex, lo);


        int pivot = nums[lo];
        int lt = lo;

        for(int i = lo + 1; i <= hi; i ++){
            if(nums[i] < pivot){
                lt ++;
                swap(nums, lt, i);
            }
        }

        swap(nums, lo, lt);
        return lt;
    }

    // 双指针快速排序
    private static int partition2(int[] nums, int lo, int hi){

        int randomIndex = RANDOM.nextInt(hi - lo + 1) + lo;
        // 交换到左边
        swap(nums, randomIndex, lo);

        int pivot = nums[lo];
        int lt = lo + 1;
        int gt = hi;

        // 循环不变量
        // all in [left + 1， lt) <= pivot
        // all in (gt, right] >= pivot
        while (true){
            while (lt <= hi && nums[lt] < pivot){
                lt ++;
            }

            while (gt > hi && nums[gt] > pivot){
                gt --;
            }

            if(lt >= gt){
                break;
            }

            swap(nums, lt, gt);
            lt ++;
            gt --;
        }

        swap(nums, lo, gt);
        return gt;
    }


    private static void quickSort2(int[] nums, int lo, int hi){
        // 快速排序
        if(hi <= lo){
            return;
        }
        // 分割
        int randomIndex = lo + RANDOM.nextInt(hi - lo + 1);
        swap(nums, lo, randomIndex);

        // 循环不变量
        // all in [left + 1, lt] < pivot
        // all in [lt + 1, i) = pivot
        // all in [gt, right] > pivot

        int pivot = nums[lo];
        int lt = lo;
        int gt = hi + 1;

        int i = lo + 1;
        while (i < gt){
            if(nums[i] < pivot){
                lt ++;
                swap(nums, i, lt);
                i++;
            }else if(nums[i] == pivot){
                i++;
            }else {
                gt --;
                swap(nums, i, gt);
            }
        }
        swap(nums, lo, lt);
        quickSort2(nums, lo, lt - 1);
        quickSort2(nums, gt, hi);


    }
}
