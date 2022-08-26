package Daily.year2022.M8.D26;

public class q1464 {
    public int maxProduct(int[] nums) {
        int max = nums[0], secondM = nums[1];

        if(max < secondM){
            int tmp = max;
            max = secondM;
            secondM = tmp;
        }

        for(int i = 2; i < nums.length; i++){
            if(nums[i] > max){
                secondM = max;
                max = nums[i];
            }else if(nums[i] > secondM){
                secondM = nums[i];
            }
        }

        return (max - 1) * (secondM - 1);
    }

}
