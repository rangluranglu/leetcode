package Daily.year2022.M8.D29;

public class q1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[n * 2];
        for (int i = 0; i < n; i++) {
            ans[i * 2] = nums[i];
            ans[i * 2 + 1] = nums[i + n];
        }

        return ans;
    }
}
