package Year2023.Daily.M5.D13;

public class q2441 {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;

        while(i < j){
            if(nums[i] * nums[j] < 0){
                while(i < j && -nums[i] > nums[j]){
                    i ++;
                }

                while(i < j && -nums[i] < nums[j]){
                    j --;
                }

                if(nums[i] * nums[j] < 0 && -nums[i] == nums[j]){
                    return nums[j];
                }
            }else {
                break;
            }
        }
        return -1;
    }
}
