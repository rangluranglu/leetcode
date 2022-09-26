package WeekCompetition.year2022.W305;

public class q2367 {
    public int arithmeticTriplets(int[] nums, int diff) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i < n - 2; i++){
            retary:
            for(int j = i +1; j < n - 1; j++){
                if(nums[j] - nums[i] == diff){
                    for(int k = j + 1; k < n; k ++){
                        if(nums[k] - nums[j] == diff){
                            ans ++;
                            break retary;
                        }
                    }
                }
            }
        }

        return ans;
    }
}
