package Year2023.Week.W328;

public class q2535 {
    public int differenceOfSum(int[] nums) {
        int ans = 0;
        int numSum = 0;
        for(int num : nums){
            ans += num;
            int tmp = num;
            while (tmp != 0){
                int c = tmp %10;
                tmp /= 10;
                numSum += c;
            }
        }

        return ans > numSum ? ans - numSum : numSum - ans;
    }
}
