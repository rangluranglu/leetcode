package Year2022.Daily.M10.D24;

public class q915 {
    public int partitionDisjoint(int[] nums) {
        // max(left) <= min(right)
        int n = nums.length;
        int leftMax = nums[0];
        int leftPos = 0, curMax = nums[0];

        for (int i = 1; i < n; i++) {
            curMax = Math.max(curMax, nums[i]);
            if(leftMax > nums[i]){
                leftMax = curMax;
                leftPos = i;
            }
        }

        return leftPos + 1;
    }
}
