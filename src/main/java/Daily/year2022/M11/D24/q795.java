package Daily.year2022.M11.D24;

public class q795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        // 单调栈, 化简
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] < left){
                nums[i] = 0;
            }else if(nums[i] > right){
                nums[i] = 2;
            }else{
                nums[i] = 1;
            }
        }
        // 转化为求不包含2，至少包含一个1的子数组数目
        int ans = 0, last2 = -1, last1 = -1;
        for (int i = 0; i < n; i++) {
            if(nums[i] == 1){
                last1 = i;
            }else if(nums[i] == 2){
                last2 = i;
                last1 = -1;
            }

            if(last1 != -1){
                ans += last1 - last2;
            }

        }

        return ans;


    }
}
