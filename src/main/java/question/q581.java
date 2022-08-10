package question;

public class q581 {
    public int findUnsortedSubarray(int[] nums) {
        // 升序
        // 从左往右，找到比左边最大值还小的最右下标，从右往左，找到比右边最小值还大的最左下标

        int n = nums.length;

        int minn = Integer.MAX_VALUE, left = -1;

        // 右边的最大值
        int maxn = Integer.MIN_VALUE, right = -1;
        // 顺序找到右边界， 逆序找到左边界
        for(int i = 0; i < n; i++){
            if(maxn > nums[i]){
                right = i;
            }else{
                maxn = nums[i];
            }

            if(minn < nums[n - 1 - i]){
                left = n - 1- i;
            }else{
                minn = nums[n - 1 - i];
            }
        }

        return right == -1 ? 0 : right - left + 1;
    }
}
