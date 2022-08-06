package question;

public class offer10 {
    public int numWays(int n) {
        int mod = (int) 1e9 + 7;
        if(n <= 1){
            return 1;
        }
        int a = 1, b = 1;
        while(n-- > 1){
            int tmp = (a + b) % mod;
            a = b;
            b = tmp;
        }

        return b;
    }
}
