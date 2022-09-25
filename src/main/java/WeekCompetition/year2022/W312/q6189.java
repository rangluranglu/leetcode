package WeekCompetition.year2022.W312;

public class q6189 {
    public int longestSubarray(int[] nums) {
        // 最长的相同
        int max = Integer.MIN_VALUE, maxLen = 0;

        for(int i = 0; i < nums.length; ){
            if(nums[i] > max){
                max = nums[i];
                maxLen = 1;

                while(i + 1< nums.length && nums[i + 1] == nums[i]){
                    i++;
                    maxLen ++;
                }
            }else if(nums[i] == max){
                int tmp = 1;
                while(i + 1< nums.length && nums[i + 1] == nums[i]){
                    i++;
                    tmp ++;
                }
                maxLen = Math.max(tmp, maxLen);
            }

            i++;
        }

        return maxLen;

    }
}
