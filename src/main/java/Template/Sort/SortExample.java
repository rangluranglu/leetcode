package Template.Sort;

/**
 * 排序算法模板类
 */
public abstract class SortExample {


    public static boolean less(int a, int b){
        return a <b;
    }


    public static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void  show(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }


    public static boolean isSorted(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            if(less(nums[i], nums[i - 1])) return false;
        }

        return true;
    }
}
