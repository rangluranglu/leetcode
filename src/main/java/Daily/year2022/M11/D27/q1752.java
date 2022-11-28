package Daily.year2022.M11.D27;

public class q1752 {
    public boolean check(int[] nums) {
        // 检测数组是否非递减排序

        int n = nums.length, x = 0;
        for (int i = 1; i < n; i++) {
            if(nums[i] < nums[i - 1]){
                x = i;
                break;
            }
        }

        if(x == 0){
            return true;
        }

        for (int i = x + 1; i < n; i++) {
            if(nums[i] < nums[i - 1]){
                return false;
            }
        }

        return nums[0] >= nums[n - 1];
    }
}
