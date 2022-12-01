package question;

public class offer51 {
    int ans = 0;
    public int reversePairs(int[] nums) {
        // 逆序对
        // 归并， 在合并的时候计算逆序对

        //
        int n = nums.length;
        int[] tmp = new int[n];

        mergeSort(nums, 0, n - 1, tmp);
        return ans;

    }

    private void mergeSort(int[] nums, int left, int right, int[] tmp) {
        if(left >= right){
            return ;
        }

        int mid = left + (right - left) / 2;

        mergeSort(nums, left, mid, tmp);
        mergeSort(nums, mid + 1, right, tmp);

        if(nums[mid] <= nums[mid + 1]){
            return;
        }

        mergeSortedArray(nums, left, mid, right, tmp);
    }

    private void mergeSortedArray(int[] nums, int left, int mid, int right, int[] tmp) {

        // 拷贝
        System.arraycopy(nums, left, tmp, left, right - left + 1);

        int i = left;
        int j = mid + 1;
        for(int k = left; k <= right; k++){
            if(i == mid + 1){
                nums[k] = tmp[j];
                j ++;
            }else if(j == right + 1){
                nums[k] = tmp[i];
                i ++;
            }else if(tmp[i] <= tmp[j]){
                nums[k] = tmp[i];
                i ++;
            }else {
                nums[k] = tmp[j];
                j++;
                ans += (mid - i + 1);
            }
        }

    }

}
