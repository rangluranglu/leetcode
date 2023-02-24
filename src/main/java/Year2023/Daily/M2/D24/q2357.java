package Year2023.Daily.M2.D24;

public class q2357 {
    public int minimumOperations(int[] nums) {
        // 2357.使数组中所有
        // 步数最小 --> 不同的个数
        int[] count = new int[101];
        for (int num : nums) {
            count[num] ++;
        }
        int ans = 0;
        for (int i = 1; i < 101; i++) {
            ans += count[i] == 0 ? 0 : 1;
        }

        return ans;
    }
}
