package Year2022.Week.W304;

import java.util.Arrays;

public class q2358 {
    public static void main(String[] args) {
        int[] nums = {10,6,12,7,3,5};
        System.out.printf("" + maximumGroups(nums));
    }
    public static int maximumGroups(int[] grades) {
        // 贪心
        Arrays.sort(grades);

        int n = grades.length;

        int ans = 1;
        while(ans * (ans + 1) <= n * 2){
            ans ++;
        }

        return ans - 1;
    }
}
