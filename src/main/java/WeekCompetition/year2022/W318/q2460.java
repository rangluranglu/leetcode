package WeekCompetition.year2022.W318;

public class q2460 {
    public int[] applyOperations(int[] nums) {
        // 不需要创建额外数组
        int idx = 0;
        int n = nums.length;

        for(int i = 0; i < n - 1; i++){
            if(nums[i] == 0){
                continue;
            }

            if(nums[i] == nums[i+1]){
                nums[i + 1] = 0;
                nums[idx ++] = nums[i] * 2;
            }else {
                nums[idx ++] = nums[i];
            }
        }

        // 最后一个数不是0
        if (nums[n - 1] != 0) {
            nums[idx ++] = nums[n - 1];
        }

        for (int i = idx; i < n; i++) {
            nums[i] = 0;
        }

        return nums;

    }
}
