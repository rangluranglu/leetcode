package question;

public class q400 {
    public int findNthDigit(int n) {
        // 找到个数
        int q = 1, digit = 9;

        while( (long) q * digit < n){
            n -= q * digit;
            q ++;
            digit *= 10;
        }

        int index = n - 1;
        int startNum = (int)Math.pow(10, q - 1);

        int digitIndex = index % q;
        int num = startNum + index / q;

        int ans = (num / (int) (Math.pow(10, q - digitIndex - 1))) % 10;
        return ans;
    }
}
