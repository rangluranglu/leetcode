package Year2022.Week.W308;

import java.util.Arrays;

public class q2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            int query = queries[i];

            int j = 0;
            int sum = 0;
            while(j < nums.length){
                sum += nums[j];
                if(sum > query){
                    ans[i] = j;
                    break;
                }

                j ++;
            }

            if(j == nums.length){
                ans[i] = nums.length;
            }
        }

        return ans;
    }
}
