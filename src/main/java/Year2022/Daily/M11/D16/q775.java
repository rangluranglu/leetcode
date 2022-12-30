package Year2022.Daily.M11.D16;

public class q775 {
    public boolean isIdealPermutation(int[] nums) {
        // 局部倒置一定是全局倒置
        // 是否有 j > i + 1 且 nums[i] > nums[j]
        // 0 - n-1 排列 ---> 最大的数是 n - 1
        // 如果n - 1 且 index < n - 2， 则一定成立

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if(i < num - 1 || i > num + 1){
                return false;
            }
        }
        return true;
    }
}
