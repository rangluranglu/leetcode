package question;

import java.util.Random;

public class q912 {
    // https://leetcode.cn/problems/sort-an-array/solutions/179489/fu-xi-ji-chu-pai-xu-suan-fa-java-by-liweiwei1419/
    public int[] sortArray(int[] nums) {
        // 冒泡排序
        // 时间O(n*2)  空间 O(1)
        int n = nums.length;

        for (int i = n -1; i >= 0; i --) {
            boolean sorted = true;
            for(int j = 0; j < i; j++){
                if(nums[j] > nums[j+1]){
                    swap(nums, j, j+1);
                    sorted = false;
                }
            }

            if(sorted){
                break;
            }
        }

        return nums;
    }

    public int[] sortArray2(int[] nums) {
        // 选择排序         时间O(n*2)  空间 O(1)
        // 每一轮选择最小的 移动到最前
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if(nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }

            swap(nums, i, minIndex);
        }
        return nums;
    }

    public int[] sortArray3(int[] nums) {
        // 插入排序         时间O(n*2)  空间 O(1)
        // 每次将一个数字插入一个有序的数组里
        int n = nums.length;

        // 将 nums[i] 插入到 [0, i) 中
        for (int i = 1; i < n; i++) {
            int tmp = nums[i];
            int j = i;

            while (j > 0 && nums[j - 1] > tmp){
                nums[j] = nums[j - 1];
                j --;
            }

            nums[j] = tmp;
        }

        return nums;
    }

    public int[] sortArray4(int[] nums) {
        // 归并排序 时间 O(NlogN) 空间 O(N)
        int n = nums.length;
        int[] tmp = new int[n];

        mergeSort(nums, 0, n - 1, tmp);

        return nums;
    }

    private void mergeSort(int[] nums, int left, int right, int[] tmp) {

        // 结束条件
        if(left >= right){
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(nums, left, mid, tmp);
        mergeSort(nums, mid + 1, right, tmp);

        if(nums[mid] <= nums[mid + 1]){
            return;
        }

        mergeOfTwoSortedArray(nums, left, mid, right, tmp);
    }

    private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right, int[] tmp) {
        // 合并两个有序的array
        System.arraycopy(nums, left, tmp, left, right - left + 1);

        int i = left;
        int j = mid +1;

        for(int k = left; k <= right; k++){
            if(i == mid + 1){
                nums[k] = tmp[j];
                j++;
            }else if(j == right + 1){
                nums[k] = tmp[i];
                i++;
            }else if (tmp[i] < tmp[j]){
                nums[k] = tmp[i];
                i++;
            }else{
                nums[k] = tmp[j];
                j++;
            }
        }
    }

    private static final Random RANDOM = new Random();
    public int[] sortArray5(int[] nums) {
        // 快速排序 时间 O(NlogN) 空间 O(N)
        // 并不是一分为2，等于切分元素的划分到同一侧， 会可能会造成递归树倾斜；
        int n = nums.length;
        quickSort(nums, 0, n - 1);

        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {

        if(left >= right){
            return;
        }

        int pIndex = partition(nums, left, right);
        quickSort(nums, left, pIndex - 1);
        quickSort(nums, pIndex + 1, right);
    }

    private void quickSort2(int[] nums, int left, int right) {

        if(left >= right){
            return;
        }

        int randomIndex = RANDOM.nextInt(right - left +1) + left;
        swap(nums, randomIndex, left);

        int pivot = nums[left];
        int lt = left;
        int gt = right +1;

        int i = left + 1;

        while (i < gt){
            if(nums[i] < pivot){
                lt ++;
                swap(nums, i, lt);
                i ++;
            }else if(nums[i] == pivot){
                i ++;
            }else{
                gt --;
                swap(nums, i, gt);
            }
        }
        swap(nums, left, lt);
        quickSort(nums, left, lt - 1);
        quickSort(nums, gt, right);
    }

    private int partition(int[] nums, int left, int right) {
        // 找打随机坐标
        // 把等于切分元素的所有元素分到了数组的同一侧，可能会造成递归树倾斜；
        int randomIndex = RANDOM.nextInt(right - left +1) + left;
        swap(nums, left, randomIndex);

        int pivot = nums[left];

        int lt = left;

        for (int i = left + 1; i <= right; i++) {
            if(nums[i] < pivot){
                lt++;
                swap(nums, i, lt);
            }
        }

        swap(nums, lt, left);
        return lt;
    }

    private int partition2(int[] nums, int left, int right) {
        // 把等于切分元素的所有元素等概率地分到了数组的两侧，避免了递归树倾斜，递归树相对平衡；
        // 双指针
        int randomIndex = RANDOM.nextInt(right - left + 1) + left;
        swap(nums, randomIndex, left);

        int pivot = nums[left];
        int lt = left + 1;
        int gt = right;

        while (true) {
            while (lt <= right && nums[lt] < lt) {
                lt++;
            }

            while (gt > left && nums[gt] > pivot) {
                gt--;
            }

            if (lt >= gt) {
                break;
            }


            swap(nums, lt, gt);
            lt++;
            gt--;
        }
        swap(nums, left, right);
        return gt;
    }

    public int[] sortArray6(int[] nums) {
        // 堆排序 时间 O(NlogN) 空间 O(N)
        // 并不是一分为2，等于切分元素的划分到同一侧， 会可能会造成递归树倾斜；
        int n = nums.length;
        // 成堆
        heapify(nums);

        for(int i = n - 1; i >= 1; ){
            swap(nums, 0, i);
            i --;
            shiftDown(nums, 0, i);
        }

        return nums;
    }

    private void heapify(int[] nums){
        int len = nums.length;

        for(int i = (len - 1) / 2; i >= 0; i--){
            shiftDown(nums, i, len - 1);
        }
    }

    private void shiftDown(int[] nums, int k, int end){
        while (2 * k + 1 <= end){
            int j = 2 * k +1;
            if(j + 1 <= end && nums[j + 1] > nums[j]){
                j ++;
            }

            if(nums[j] > nums[k]){
                swap(nums, j, k);
            }else {
                break;
            }

            k = j;
        }
    }


    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
