package Year2023.Week.W348;

public class q2717 {
    public int semiOrderedPermutation(int[] nums) {

        int startI = 0, endI = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] == 1){
                startI = i;
            }
            if(nums[i] == n){
                endI = i;
            }
        }
        if(startI == 0 && endI == n - 1){
            return 0;
        }

        if(startI > endI){
            return  startI + n - 2 - endI;
        }else {
            return startI + n - 1 - endI;
        }
    }
}
