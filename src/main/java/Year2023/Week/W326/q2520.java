package Year2023.Week.W326;

public class q2520 {
    public int countDigits(int num) {
        int tmp = num, ans = 0;

        while (num != 0){
            int c = num % 10;
            num /= 10;

            if(tmp % c == 0){
                ans ++;
            }
        }

        return ans;

        // 可以优化
    }
}
