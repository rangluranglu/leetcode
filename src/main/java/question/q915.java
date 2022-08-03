package question;

public class q915 {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMin = new int[n];
        leftMax[0] = nums[0];
        rightMin[n - 1] = nums[n - 1];


        for(int i = 0; i < n; i++){
            if(i != 0){
                leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
                rightMin[n - 1 - i] = Math.min(rightMin[n - i], nums[n - 1 - i]);
            }

        }
        //System.out.println(Arrays.toString(leftMax));
        //System.out.println(Arrays.toString(rightMin));

        for(int i = 0; i < n - 1; i++){
            if(leftMax[i] <= rightMin[i + 1]){
                return i + 1;
            }
        }

        return -1;
    }
}
