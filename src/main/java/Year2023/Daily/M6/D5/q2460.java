package Year2023.Daily.M6.D5;

public class q2460 {
    public int[] applyOperations(int[] nums) {
        // 模拟
        int n = nums.length;
        for(int i = 0; i < n - 1; i++){
            // 模拟
            if(nums[i] == nums[i + 1]){
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }


        // 移动非0
        int idx = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] != 0){
                nums[idx] = nums[i];
                idx ++;
            }
        }

        while (idx < n){
            nums[idx ++] = 0;
        }
        return nums;

    }
}
