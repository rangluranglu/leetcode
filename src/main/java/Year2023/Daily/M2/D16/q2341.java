package Year2023.Daily.M2.D16;

public class q2341 {
    public int[] numberOfPairs(int[] nums) {
        int[] count = new int[101];

        for(int num : nums){
            count[num]++;
        }
        int[] ans = new int[2];
        for (int i = 0; i < 101; i++) {
            ans[0] += count[i] / 2;
            ans[1] += count[i] % 2;

        }

        return ans;
    }
}
